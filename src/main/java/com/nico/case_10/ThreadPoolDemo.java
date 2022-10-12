package com.nico.case_10;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/11 11:39
 */
@Slf4j(topic = "case_10.ThreadPoolDemo")
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(1, 1000, TimeUnit.MILLISECONDS, 1, (queue, task) -> {
            queue.put(task);
            //1 死等
            //2 超时等待
            //3 让调用者放弃任务执行 任务队列满时 任务没被放入队列中
            //4 让调用者抛出一异常 主线程抛出异常 后面的execute都没执行
            //5 让调用者自己执行任务
        });
        for(int i = 0;i < 3;++i) {
            //lambda可看作一种局部匿名内部类 只能访问外部的不可变变量
            int j = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(20000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.debug("{}",j);
            });
        }
    }
}

@FunctionalInterface
interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}

@Slf4j(topic = "case_10.TreadPool")
class ThreadPool {
    //任务队列
    private BlockingQueue<Runnable> taskQueue;
    //线程集合
    private HashSet<Worker> workers = new HashSet<>();

    //核心线程数
    private int coreSize;

    //超时时间
    private long timeout;

    //时间单位刻度
    private TimeUnit timeUnit;

    //拒绝策略
    private RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit,int queueCapcity,RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapcity);
        this.rejectPolicy = rejectPolicy;
    }

    public void execute(Runnable task) {
        //粗略的线程创建策略 当线程数小于coreSize 新建线程处理任务
        //否则 放入任务队列等待线程池线程消费
        //workers是一个共享资源
        synchronized (workers) {
            if(workers.size() < coreSize) {
                Worker worker = new Worker(task);
                log.debug("新增 worker{}, {}", worker, task);
                workers.add(worker);
                worker.start();
            }else {
                //任务放入队列的选择 拒绝策略
//                taskQueue.offer(task,timeout, timeUnit);
                taskQueue.tryPut(rejectPolicy, task);
            }
        }
    }

    class Worker extends Thread {
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            //不为空执行任务
            //为空 从任务队列里再取一个
            while (task != null || (task = taskQueue.poll(timeout,timeUnit)) != null) {
                try {
                    log.debug("正在执行...{}", task);
                    task.run();
                } catch (Exception e) {
                    log.debug(e.getMessage());
                } finally {
                    task = null;
                }
            }
            //不使用ReentrantLock 只有一个线程执行 需要保护的临界资源是workers
            synchronized (workers) {
                log.debug("worker 被移除{}", this);
                workers.remove(this);
            }
        }
    }
}

@Slf4j(topic = "case_10.BlockingQueue")
class BlockingQueue<T> {
    //任务队列
    private Deque<T> queue = new ArrayDeque<>();
    //容量
    private int capcity;
    //锁
    private ReentrantLock lock = new ReentrantLock();
    //生产者信号量
    private Condition fullWaitSet = lock.newCondition();
    //消费者信号量
    private Condition emptyWaitSet = lock.newCondition();

    public BlockingQueue(int capcity) {
        this.capcity = capcity;
    }

    /**
     * 阻塞获取任务
     * @return
     */
    public T take() {
        try {
            lock.lock();
            while (queue.isEmpty()) {
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    log.debug(e.getMessage());
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    /**
     * 带超时的阻塞获取
     * @return
     */
    public T poll(long timeout, TimeUnit timeUnit) {
        try {
            lock.lock();
            long nanos = timeUnit.toNanos(timeout);
            while(queue.isEmpty()) {
                try {
                    //已超时
                    if(nanos <= 0) {
                        return null;
                    }
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    log.debug(e.getMessage());
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }

    }

    /**
     * 阻塞添加任务
     * @param task
     */
    public void put(T task) {
        try {
            lock.lock();
            while(queue.size() == capcity) {
                try {
                    log.debug("等待加入任务队列 {} ...", task);
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    log.debug(e.getMessage());
                }
            }
            log.debug("加入任务队列 {}", task);
            queue.addLast(task);
            emptyWaitSet.signal();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 超时阻塞加入
     * @param task
     * @param timeout
     * @param timeUnit
     * @return
     */
    public boolean offer(T task,long timeout,TimeUnit timeUnit) {
        try {
            lock.lock();
            long nanos = timeUnit.toNanos(timeout);
            while(queue.size() == capcity) {
                try {
                    if (nanos <= 0) {
                        return false;
                    }
                    log.debug("等待加入任务队列 {} ...,剩余时间 {}", task,nanos);
                    nanos = fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    log.debug(e.getMessage());
                }
            }
            log.debug("加入任务队列 {}", task);
            queue.addLast(task);
            emptyWaitSet.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 线程安全的阻塞队列长度
     * @return
     */
    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            if(queue.size() == capcity) {
                rejectPolicy.reject(this, task);
            }else {
                log.debug("加入任务队列 {}", task);
                queue.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}



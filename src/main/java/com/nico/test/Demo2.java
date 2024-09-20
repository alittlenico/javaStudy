package com.nico.test;

import java.util.Deque;
import java.util.HashSet;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2023/4/7 10:35
 */
public class Demo2 {
    ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        Demo2 test = new Demo2();
        test.showTwoThread();
        HashSet<String> set = new HashSet<>();
        set.add("1");
        StringBuilder sb = new StringBuilder();
        sb.setLength();
        /**
         *
         */
    }

    public void showTwoThread() {
        new Thread(() -> {
            threadLocal.set("Thread1");
            System.out.println("I am " + threadLocal.get());
            threadLocal.set("Tread1 修改");
            System.out.println("I am " + threadLocal.get());
        }).start();

        new Thread(() -> {
            threadLocal.set("Thread2");
            System.out.println("I am " + threadLocal.get());
        }).start();
    }
}

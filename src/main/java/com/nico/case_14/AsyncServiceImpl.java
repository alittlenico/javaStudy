package com.nico.case_14;

import com.nico.case_14.domain.MeterDataFactorBaseMapping;
import com.nico.case_14.mapper.MeterDataFactorBaseMappingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/11/15 22:01
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService{

    @Async("asyncServiceExecutor")
    public void executeAsync(List<MeterDataFactorBaseMapping> records,
                             MeterDataFactorBaseMappingMapper mapper, CountDownLatch countDownLatch) {
        try{
            log.warn("start executeAsync");
            //异步线程要做的事情
            mapper.addBatch(records);
            log.warn("end executeAsync");
        }finally {
            countDownLatch.countDown();// 很关键, 无论上面程序是否异常必须执行countDown,否则await无法释放
        }
    }
}

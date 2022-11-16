package com.nico.case_14;

import com.google.common.collect.Lists;
import com.nico.case_14.domain.MeterDataFactorBaseMapping;
import com.nico.case_14.mapper.MeterDataFactorBaseMappingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import java.time.Duration;
=======
>>>>>>> 2e95e9a2bb6d0f5a9b899afd89d01cceb252a41a
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author liuyi
 * @version 1.0
 * @description:
 * @date 2022/11/15 22:18
 */
@RestController
@RequestMapping("/case_14")
@Slf4j(topic = "InsertController")
public class InsertController {

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private MeterDataFactorBaseMappingMapper mapper;

    @PostMapping("insert")
    public void insert() {
        List<MeterDataFactorBaseMapping> records = getRecords();
        LocalDateTime start = LocalDateTime.now();
        log.info("开始:{}",start);
        List<List<MeterDataFactorBaseMapping>> partition = Lists.partition(records, 1000);
        CountDownLatch countDownLatch = new CountDownLatch(partition.size());
        for(List<MeterDataFactorBaseMapping> recordSub : partition) {
            asyncService.executeAsync(recordSub, mapper, countDownLatch);
        }
        try {
            countDownLatch.await();
            LocalDateTime end = LocalDateTime.now();
            log.info("结束:{}",end);
<<<<<<< HEAD
            log.info("花费:{}", Duration.between(start, end).toSeconds());
=======
>>>>>>> 2e95e9a2bb6d0f5a9b899afd89d01cceb252a41a
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<MeterDataFactorBaseMapping> getRecords() {
        List<MeterDataFactorBaseMapping> records = new ArrayList<>();
        for(int i = 0;i < 2 * 1e6;i++) {
            MeterDataFactorBaseMapping entity = new MeterDataFactorBaseMapping();
            entity.setCreateUser(1L);
            entity.setMeterDataFactorBaseId(1L);
            entity.setInterfaceType("10");
            entity.setInterfaceCode("10");
            entity.setCreateDate(LocalDateTime.now());
            records.add(entity);
        }
        return records;
    }
}

package com.nico.case_14;

import com.nico.case_14.domain.MeterDataFactorBaseMapping;
import com.nico.case_14.mapper.MeterDataFactorBaseMappingMapper;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/11/15 22:40
 */
public interface AsyncService {
    void executeAsync(List<MeterDataFactorBaseMapping> records,
                      MeterDataFactorBaseMappingMapper mapper, CountDownLatch countDownLatch);
}

package com.nico.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 21:29
 */
public class Test {
    public static void main(String[] args) {
        List<BigDecimal> a = new ArrayList<>();
        a.add(new BigDecimal(1));

        List<BigDecimal> b = new ArrayList<>();
        b.addAll(a);
        for(int i = 0;i < 2;++i) {}
    }
}

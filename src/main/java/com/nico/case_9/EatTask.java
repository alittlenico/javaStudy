package com.nico.case_9;

import org.springframework.stereotype.Component;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/10 17:14
 */
@Component("eat")
public class EatTask implements Task{
    @Override
    public void doWhat() {
        System.out.println("吃吃吃");
    }
}

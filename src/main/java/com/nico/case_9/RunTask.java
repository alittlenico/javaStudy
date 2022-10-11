package com.nico.case_9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/10 17:17
 */
@Component("run")
public class RunTask implements Task{

    @Override
    public void doWhat() {
        System.out.println("跑跑跑");
    }
}

package com.nico.case_9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/10 17:13
 */
@RestController
@RequestMapping("/case_9")
public class Demo {
    private Task task;

    @Autowired
    public Demo(@Qualifier("run") Task task) {
        this.task = task;
    }

    @GetMapping("/doTask")
    public String doTask() {
        this.task.doWhat();
        return "hello";
    }
}

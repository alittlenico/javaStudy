package com.nico.case_7.callable_demo;

import com.nico.case_7.ResponseMsg;
import com.nico.case_7.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/7 17:42
 */
//@RestController
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Callable<ResponseMsg<String>> getResult(){

        log.info("接收请求，开始处理...");

        Callable<ResponseMsg<String>> result = (()->{
            return taskService.getResult();
        });

        log.info("接收任务线程完成并退出");

        return result;
    }

}

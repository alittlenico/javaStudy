package com.nico.case_7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyi
 * @version 1.0
 * @description: block会阻塞住controller接收请求，直到接收结果完成，才会执行下一条语句
 * @date 2022/10/7 17:38
 */
@RestController
@RequestMapping("/case_7/BlockController")
public class BlockController {

    private static final Logger log = LoggerFactory.getLogger(BlockController.class);

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseMsg<String> getResult(){

        log.info("接收请求，开始处理...");
        ResponseMsg<String> result =  taskService.getResult();
        log.info("接收任务线程完成并退出");

        return result;

    }
}

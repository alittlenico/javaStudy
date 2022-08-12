package com.nico.case_1.handler;

import com.nico.case_1.utils.Result;
import com.nico.case_1.utils.ResultWrapper;
import com.nico.case_1.exception.RRException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/20 11:08
 */
@Slf4j
//@RestControllerAdvice
public class RRExceptionHandler {
    /**
     * 处理自定义异常
     */
//    @ExceptionHandler(RRException.class)
//    public Result handleRRException(RRException e){
//        log.debug(e.getMessage(), e);
//        System.out.println(e.toString());
//        return ResultWrapper.error(e.getMsg());
//    }
//
//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseBody
//    public Result handlerNoFoundException(NoHandlerFoundException e) {
//        log.error(e.getMessage(), e);
//        e.printStackTrace();
//        return ResultWrapper.error("路径不存在，请检查路径是否正确");
//    }
//
//    @ExceptionHandler(Exception.class)
//    public Result handleException(Exception e){
//        log.error(e.getMessage(), e);
//        e.printStackTrace();
//        return ResultWrapper.error("未知异常，请联系管理员");
//    }
}

package com.nico.case_2.domain;


import com.nico.case_2.result.ResultCode;
import com.nico.case_2.result.StatusCode;
import lombok.Data;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/21 10:54
 */
@Data
public class ResultVo {
    private int code;
    private String msg;
    private Object data;

    public ResultVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 默认返回成功状态码，数据对象
    public ResultVo(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    // 返回指定状态码，数据对象
    public ResultVo(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;

    }

    //只返回状态码
    public ResultVo(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }
}

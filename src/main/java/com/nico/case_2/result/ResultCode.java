package com.nico.case_2.result;

import lombok.Getter;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/21 10:50
 */
@Getter
public enum ResultCode implements StatusCode{
    SUCCESS(1000, "请求成功"),
    FAILED(1001, "请求失败"),
    VALIDATE_ERROR(1002, "参数校验失败"),
    RESPONSE_PACK_ERROR(1003, "response返回包装失败");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

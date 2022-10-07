package com.nico.case_7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/7 17:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMsg<T> {

    private int code;

    private String msg;

    private T data;

}

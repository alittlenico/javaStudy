package com.nico.case_1.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/19 10:22
 */
@Data
@Valid
public class Person1 {
    //@NotBlank
    @Pattern(regexp = "^[1-9]\\d{5}(?:18|19|20)\\d{2}(?:0[1-9]|10|11|12)(?:0[1-9]|[1-2]\\d|30|31)\\d{3}[0-9Xx]$", message = "身份证校验错误")
    private String idcard;

    private String name;
}

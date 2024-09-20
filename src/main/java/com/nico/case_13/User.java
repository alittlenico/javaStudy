package com.nico.case_13;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/11/15 16:51
 */
@ApiModel("用户")
@Data
public class User {
    @ApiModelProperty("年龄")
    private int age;
    @ApiModelProperty("名字")
    private String name;
}

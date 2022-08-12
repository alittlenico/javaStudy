package com.nico.case_1.entity;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author liuyi
 * @version 1.0
 * @description: 分组校验测试
 * @date 2022/7/19 21:43
 */
@Validated
@Data
public class Student {

    @NotNull(groups = Update.class)
    private Long userId;
    @NotEmpty(message = "姓名不能为空", groups = {Save.class, Update.class})
    private String userName;

    /**
     * 保存时候校验分组
     */
    public interface Save {

    }

    /**
     * 更新时候校验分组
     */
    public interface Update {

    }

}

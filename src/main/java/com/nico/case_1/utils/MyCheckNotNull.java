package com.nico.case_1.utils;

import java.lang.annotation.*;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/19 21:44
 */
@Target({ElementType.METHOD, ElementType.FIELD ,ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyCheckNotNull {
    String value();
}

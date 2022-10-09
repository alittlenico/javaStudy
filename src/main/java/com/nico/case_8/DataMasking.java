package com.nico.case_8;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataMasking {

    //数据脱敏策略
    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MASK;

}

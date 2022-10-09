package com.nico.case_8;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/7 19:05
 */
public interface DataMaskingOperation {

    String MASK_CHAR = "*";

    String mask(String content, String maskChar);

}

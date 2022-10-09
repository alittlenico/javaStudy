package com.nico.case_8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/9 11:26
 */
@Data
@AllArgsConstructor
public class MyAddress implements Serializable {
//    @DataMasking(maskFunc = DataMaskingFunc.NO_MASK)
    private String province;
    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String street;
}

package com.nico.case_8;



import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/9 11:24
 */
@Data
@AllArgsConstructor
public class User implements Serializable {

    private Long id;
    private String name;
    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String email;
    private MyAddress address;
}

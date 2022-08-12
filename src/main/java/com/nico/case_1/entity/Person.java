package com.nico.case_1.entity;

import javax.validation.constraints.NotEmpty;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/19 21:05
 */

//@Validated
//@Valid
public class Person {
//    @MyCheckNotNull("名字必填")
//    @NotEmpty
//    @EncryptId
    @NotEmpty
    private String name;

    //@NotEmpty(message = "身份证不能为空")
//    @Cid
    private String idCard;

//    @MyCheckNotNull("名字必填")
    public void setName(String name) {
        this.name = name;
    }

//    @MyCheckNotNull("名字必填")
    public String getName() {
        return name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}

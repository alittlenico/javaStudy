package com.nico.case_3;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/30 22:15
 */
@Data
public class A {
    private Long id;
    private String name;
    private List<B> list = new ArrayList<>();
}

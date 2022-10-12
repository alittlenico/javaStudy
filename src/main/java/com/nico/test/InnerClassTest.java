package com.nico.test;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/11 14:44
 */

public class Demo {
    public static void main(String[] args) {
        Outer.InnerClz innerClz = new Outer().new InnerClz();
    }
}

class Outer {

    public Outer() {

    }

    void init() {
        InnerClz innerClz = new InnerClz();
    }

    public class InnerClz {
        public InnerClz() {

        }
    }
}

package com.nico.test;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/10/11 14:44
 */

public class InnerClassTest {
    public static void main(String[] args) {

    }
}

class Outer {
    private boolean flag;

    public Outer(boolean flag) {
        this.flag = flag;
    }

    public void init(boolean flag) {
        class InnerClz {

            public void say() {
                if (flag) {
                    System.out.println("hello world");
                }
            }
        }
        InnerClz innerClz = new InnerClz();
    }


}

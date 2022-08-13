package com.nico.case_5;

import com.nico.case_4.City;
import org.junit.jupiter.api.Test;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 12:11
 */
public class CloneTest {

    /**
     * 浅拷贝:拷贝对象和原对象所有值的属性相同,对象属性的引用也相同
     * @throws CloneNotSupportedException
     */
    @Test
    public void shallowCopy() throws CloneNotSupportedException {
        Person p = new Person("liuyi", 25, new City(1L, "江西省", "吉安市", "泰和"));
        Person p1 = (Person) p.clone();
        p1.setAge(18);
        p1.getCity().setProvince("北京市");
        System.out.println(p.toString());
        System.out.println(p==p1);//false
        System.out.println(p.getCity()==p1.getCity());//true
        System.out.println(p1.toString());
    }

    /**
     * 1.修改属性对象clone
     * 2.在当前对象clone方法中显式修改属性的clone
     * @throws CloneNotSupportedException
     */
    @Test
    public void deepCopy() throws CloneNotSupportedException {
        Person p = new Person("liuyi", 25, new City(1L, "江西省", "吉安市", "泰和"));
        Person p1 = (Person) p.clone();
        p1.setAge(18);
        p1.getCity().setProvince("北京市");
        System.out.println(p.toString());
        System.out.println(p==p1);//false
        System.out.println(p.getCity()==p1.getCity());//false
        System.out.println(p1.toString());
    }

    /**
     * 通过序列化来实现深拷贝
     */
    @Test
    public void deepCopyBySerializable() {
        Person1 p = new Person1("liuyi", 25, new City(1L, "江西省", "吉安市", "泰和"));
        Person1 p1 = (Person1) p.deepClone();
        p1.setAge(18);
        p1.getCity().setProvince("北京市");
        p1.getCity().setCity("北京市");
        p1.getCity().setArea("海淀区");
        System.out.println(p.toString());
        System.out.println(p==p1);//false
        System.out.println(p.getCity()==p1.getCity());//false
        System.out.println(p1.toString());
    }
}

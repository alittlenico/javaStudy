package com.nico.case_5;

import com.nico.case_4.City;
import lombok.Data;

import java.io.*;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 16:02
 */
@Data
public class Person1 implements Serializable {
    private String name;
    private int age;
    private City city;

    public Person1(String name, int age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }


    /**
     * 使用序列化的方式来进行深拷贝
     * @return
     */
//    public Person1 deepClone() {
//        Person1 p1 = this;
//        Person1 p2 = null;
//        PipedOutputStream out = new PipedOutputStream();
//        PipedInputStream in = new PipedInputStream();
//        try {
//            in.connect(out);
//        }catch (IOException e) {
//            e.getStackTrace();
//        }
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(out);
//            ObjectInputStream ois = new ObjectInputStream(in);
//            oos.writeObject(p1);
//            Thread.sleep(1000);
//            p2 = (Person1)ois.readObject();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return p2;
//    }

    public Person1 deepClone() {

        Person1 p2=null;

        Person1 p1=this;

        PipedOutputStream out=new PipedOutputStream();

        PipedInputStream in=new PipedInputStream();

        try {

            in.connect(out);

        } catch (IOException e) {e.printStackTrace();

        }

        try(ObjectOutputStream bo=new ObjectOutputStream(out);

            ObjectInputStream bi=new ObjectInputStream(in);) {

            bo.writeObject(p1);

            p2=(Person1) bi.readObject();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return p2;}
}

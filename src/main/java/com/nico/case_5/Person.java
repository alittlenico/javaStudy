package com.nico.case_5;

import com.nico.case_4.City;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 12:16
 */
@Data//(@setter @getter @toString @RequiredArgsConstructor @EqualsAndHashCode)
@NoArgsConstructor
public class Person implements Cloneable{
    private String name;
    private int age;
    private City city;

    public Person(String name, int age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        City c = ((Person) clone).getCity();
        ((Person)clone).setCity((City) c.clone());
        return clone;
    }
}

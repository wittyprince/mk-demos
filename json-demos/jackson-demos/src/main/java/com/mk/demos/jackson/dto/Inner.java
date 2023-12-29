package com.mk.demos.jackson.dto;

/**
 * inner
 *
 * @author WangChen
 * Created on 2022/10/18
 * @since 1.0
 */
public class Inner {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Inner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

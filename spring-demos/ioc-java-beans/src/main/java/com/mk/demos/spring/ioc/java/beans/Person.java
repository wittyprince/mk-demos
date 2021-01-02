package com.mk.demos.spring.ioc.java.beans;

/**
 * 普通POJO类
 *
 * Setter/Getter
 * 在JavaBeans中对应的是可写Writable/可读Readable
 * @author WangChen
 * Created on 2021/1/2 15:22
 * @since
 */
public class Person {

    private String name;//字段称为属性property
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
        return super.toString();
    }
}

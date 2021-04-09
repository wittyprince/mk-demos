package com.mk.demos.spring.model;

/**
 * User实体类
 *
 * @author WangChen
 * Created on 2021/4/9 15:18
 * @since 1.0
 */
public class User {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

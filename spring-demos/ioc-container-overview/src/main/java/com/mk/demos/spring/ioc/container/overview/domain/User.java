package com.mk.demos.spring.ioc.container.overview.domain;

/**
 * User POJO类
 *
 * @author WangChen
 * Created on 2021/1/2 17:45
 * @since 1.0
 */
public class User {

    public User() {
        System.out.println("I am user constructor...");
    }

    private Long id;
    private String name;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

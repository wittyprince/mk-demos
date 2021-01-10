package com.mk.demos.spring.annotation.model;

/**
 * User POJO
 *
 * @author WangChen
 * Created on 2021/1/10 10:54
 * @since 1.0
 */
public class User {

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
}

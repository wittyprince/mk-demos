package com.mk.demos.spring.boot.vo;

/**
 * @author WangChen
 * Created on 2019/10/28 8:56
 * @since
 */
public class UserVO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }
}

package com.mk.demos.java.serializable;

import java.io.Serializable;

/**
 * A
 *
 * @author WangChen
 * Created on 2022/9/6
 * @since 1.0
 */
public class A implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

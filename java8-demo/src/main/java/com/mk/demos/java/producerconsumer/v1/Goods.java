package com.mk.demos.java.producerconsumer.v1;

/**
 * 生产的物品
 *
 * @author WangChen
 * Created on 2022/8/11
 * @since 1.0
 */
public class Goods {

    private Integer id;  // id
    private String name; // name

    public Goods() {
    }

    public Goods(String name) {
        this.name = name;
    }

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

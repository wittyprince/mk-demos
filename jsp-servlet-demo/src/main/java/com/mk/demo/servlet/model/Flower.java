package com.mk.demo.servlet.model;

/**
 * flower
 *
 * 所有的 POJO 类属性必须使用包装数据类型
 *
 * Created by WangChen on 2019/4/2 22:39.
 */
public class Flower {

    private Integer id;
    private String name;
    private Double price;
    private String production;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}

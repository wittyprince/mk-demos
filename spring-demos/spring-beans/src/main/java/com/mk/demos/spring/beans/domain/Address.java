package com.mk.demos.spring.beans.domain;

/**
 * 地址 POJO 类
 *
 * @author WangChen
 * Created on 2021/1/7 15:19
 * @since 1.0
 */
public class Address {

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
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Address createAddress(){
        Address address = new Address();
        address.setId(1L);
        address.setName("shanghai-static-method");
        return address;
    }
}

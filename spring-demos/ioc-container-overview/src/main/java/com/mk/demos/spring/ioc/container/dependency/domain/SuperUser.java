package com.mk.demos.spring.ioc.container.dependency.domain;

import com.mk.demos.spring.ioc.container.dependency.annotation.Super;

/**
 * 超级用户POJO类
 *
 * @author WangChen
 * Created on 2021/1/3 10:57
 * @since 1.0
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}

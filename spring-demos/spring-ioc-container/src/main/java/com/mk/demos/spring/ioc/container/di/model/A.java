package com.mk.demos.spring.ioc.container.di.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * a
 *
 * @author WangChen
 * Created on 2022/8/18
 * @since 1.0
 */
@Component
public class A {

//    @Autowired
    private B b;

    public A() {
        System.out.println("A 空构造方法...");
    }

    @Autowired
    public A(B b) {
        this.b = b;
        System.out.println("A 有参构造方法...");
    }

//    @Autowired
    public void setB(B b) {
        this.b = b;
    }
}

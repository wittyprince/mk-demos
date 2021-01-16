package com.mk.demos.design.pattern.proxy.fromother.cglib;

/**
 * Cglib 代理模式中 被代理的委托类
 *
 * @author WangChen
 * Created on 2021/1/15 20:10
 * @since 1.0
 */
public class Dog {

    public String bark() {
        System.out.println("sparking...");
        return "Dog...";
    }
}

package com.mk.demos.design.pattern.proxy;

/**
 * car 需要被代理的类
 * move() 需要被代理的方法
 *
 * 需求：在car#move方法前后添加一些逻辑，如增加日志输出、添加时间等
 *
 * @author WangChen
 * Created on 2021/1/10 19:57
 * @since 1.0
 */
public class Car implements Movable{

    @Override
    public void move() {
        System.out.println("car moving...");
    }
}

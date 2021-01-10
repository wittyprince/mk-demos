package com.mk.demos.design.pattern.proxy.jstatic;

import com.mk.demos.design.pattern.proxy.Car;
import com.mk.demos.design.pattern.proxy.Movable;

/**
 * 使用聚合方式(组合方式)对Car中的move方法进行代理
 *
 * 静态代理：方法二：聚合方式
 *
 * 面向对象(OOP)设计原则: 多用组合，少用继承
 *
 * 	- 组合 (关系更强)
 * 		○ 类是成员变量(contains-a)
 * 	- 聚合  (关系较组合弱)
 *      ○ 类是成员变量(has-a)
 *
 * @author WangChen
 * Created on 2021/1/10 20:13
 * @since 1.0
 */
public class AggregationCarProxy implements Movable {

    /**
     * AggregationCarProxy类持有Car类
     * 可以把AggregationCarProxy看成是Car的一个代理
     */
    private Car car;

    public AggregationCarProxy(Car car) {
        this.car = car;
    }

    @Override
    public void move() {
        System.out.println("AggregationCarProxy start...");
        car.move();
        System.out.println("AggregationCarProxy end...");
    }
}

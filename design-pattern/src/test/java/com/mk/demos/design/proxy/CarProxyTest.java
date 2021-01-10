package com.mk.demos.design.proxy;

import org.junit.Test;

import com.mk.demos.design.pattern.proxy.Car;
import com.mk.demos.design.pattern.proxy.jstatic.CarLogProxy;
import com.mk.demos.design.pattern.proxy.jstatic.CarTimeProxy;

/**
 * Car聚合方式代理测试类
 *
 * 聚合(组合)较继承代理方式，更具有灵活性
 *
 * @author WangChen
 * Created on 2021/1/10 21:34
 * @since 1.0
 */
public class CarProxyTest {


    @Test
    public void test(){
        Car car = new Car();
        // 需求一：先对Car#move方法添加时间记录，再加日志记录
        CarTimeProxy timeProxy = new CarTimeProxy(car);
        CarLogProxy logProxy = new CarLogProxy(timeProxy);
        logProxy.move();
        System.out.println("=============================");
        // 需求二：先对Car#move方法添加日志记录，再加时间记录
        CarLogProxy logProxy2 = new CarLogProxy(car);
        CarTimeProxy timeProxy2 = new CarTimeProxy(logProxy2);
        timeProxy2.move();
    }
}

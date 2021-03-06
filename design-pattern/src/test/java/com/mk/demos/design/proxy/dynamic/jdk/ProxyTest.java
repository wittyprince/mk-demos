package com.mk.demos.design.proxy.dynamic.jdk;

import org.junit.Test;

import com.mk.demos.design.pattern.proxy.Car;
import com.mk.demos.design.pattern.proxy.Movable;
import com.mk.demos.design.pattern.proxy.dynamic.jdk.Proxy;
import com.mk.demos.design.pattern.proxy.dynamic.jdk.TimeHandler;

/**
 * 动态代理类测试类
 *
 * @author WangChen
 * Created on 2021/1/11 20:45
 * @since 1.0
 */
public class ProxyTest {


    @Test
    public void test() throws Exception {
        Car car = new Car();
        Movable movable = (Movable) Proxy.newProxyInstance(Movable.class, new TimeHandler(car));

        movable.move();

    }

    @Test
    public void test2(){
        String s = System.getProperty("user.dir");
        System.out.println(s.replaceAll("\\\\", "/"));

        Class clazz = Movable.class;
        System.out.println(clazz.getName());
    }
}

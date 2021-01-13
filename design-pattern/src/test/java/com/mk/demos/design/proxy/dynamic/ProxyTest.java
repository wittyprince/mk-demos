package com.mk.demos.design.proxy.dynamic;

import java.io.IOException;

import org.junit.Test;

import com.mk.demos.design.pattern.proxy.Car;
import com.mk.demos.design.pattern.proxy.Movable;
import com.mk.demos.design.pattern.proxy.dynamic.Proxy;

/**
 * 动态代理类测试类
 *
 * @author WangChen
 * Created on 2021/1/11 20:45
 * @since 1.0
 */
public class ProxyTest {


    @Test
    public void test() throws IOException {
        Car car = new Car();
        Movable movable = (Movable) Proxy.newProxyInstance();

//        movable.move();

    }

    @Test
    public void test2(){
        System.out.println(System.getProperty("user.dir"));
    }
}

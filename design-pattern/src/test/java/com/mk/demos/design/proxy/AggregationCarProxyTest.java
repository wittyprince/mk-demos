package com.mk.demos.design.proxy;

import org.junit.Test;

import com.mk.demos.design.pattern.proxy.Car;
import com.mk.demos.design.pattern.proxy.jstatic.AggregationCarProxy;

/**
 * AggregationCarProxy测试列
 *
 * @author WangChen
 * Created on 2021/1/10 21:27
 * @since 1.0
 */
public class AggregationCarProxyTest {

    @Test
    public void test(){
        Car car = new Car();
        AggregationCarProxy carProxy = new AggregationCarProxy(car);
        carProxy.move();
    }
}

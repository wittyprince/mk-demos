package com.mk.demos.design.proxy;

import org.junit.Test;

import com.mk.demos.design.pattern.proxy.jstatic.GeneralizationCarProxy;

/**
 * CarGeneralizationProxy 测试类
 *
 * @author WangChen
 * Created on 2021/1/10 20:04
 * @since 1.0
 */
public class GeneralizationCarProxyTest {

    @Test
    public void test(){
        GeneralizationCarProxy carProxy = new GeneralizationCarProxy();
        carProxy.move();
    }
}

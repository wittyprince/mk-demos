package com.mk.demos.design.pattern.proxy.dynamic.jdk;

import java.lang.reflect.Method;

/**
 * 方法调用处理器InvocationHandler-模拟JDK InvocationHandler
 *
 * @author WangChen
 * Created on 2021/1/14 19:33
 * @since 1.0
 */
public interface InvocationHandler {

    /**
     *
     * @param proxy     代表动态生成的 动态代理 对象实例
     * @param method    需要代理的方法
     * @param args      需要代理的方法的参数
     * @return  Object 返回值
     * @throws Throwable 异常
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}

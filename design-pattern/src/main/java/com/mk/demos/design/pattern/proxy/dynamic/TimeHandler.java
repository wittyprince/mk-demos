package com.mk.demos.design.pattern.proxy.dynamic;

import java.lang.reflect.Method;

/**
 * 时间处理器
 *
 * @author WangChen
 * Created on 2021/1/14 19:36
 * @since 1.0
 */
public class TimeHandler implements InvocationHandler{

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("TimeProxy start...");
        method.invoke(target, args);
        System.out.println("TimeProxy end...");
        return null;
    }
}

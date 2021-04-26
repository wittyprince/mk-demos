package com.mk.demos.spring.aop;

import org.springframework.aop.framework.AopContext;

/**
 * @author WangChen
 * Created on 2021/4/26 19:25
 * @since
 */
public class SimplePojo implements Pojo{
    @Override
    public void foo() {
        System.out.println("foo...");
        // this next method invocation is a direct call on the 'this' reference
        this.bar();
        // 如果需要走AOP代理，需要通过AopContext.currentProxy()来调用，同时需要设置exposeProxy=true
        // ((Pojo) AopContext.currentProxy()).bar();
    }

    public void bar() {
        // some logic...
        System.out.println("bar...");
    }
}

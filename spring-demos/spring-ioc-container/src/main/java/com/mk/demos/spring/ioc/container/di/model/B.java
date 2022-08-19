package com.mk.demos.spring.ioc.container.di.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * b
 *
 * @author WangChen
 * Created on 2022/8/18
 * @since 1.0
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS) // 如果是原型，则不会有循环依赖问题
public class B {

//    @Autowired
    private A a;

    public B() {
        System.out.println("B 空构造方法...");
    }

//    @Autowired
    public B(A a) {
        this.a = a;
        System.out.println("B 有参构造方法...");
    }

    @Autowired
    public void setA(A a) {
        this.a = a;
    }
}

package com.mk.demos.spring.beans.factory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * AddressFactory默认实现
 *
 * @author WangChen
 * Created on 2021/1/7 21:07
 * @since 1.0
 */
public class DefaultAddressFactory implements AddressFactory, InitializingBean, DisposableBean {

    // 1. @PostConstruct标注方法, @PostConstruct是Java的标准注解(JDK1.6开始有)
    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct: init...");
    }

    // 2. 实现Initialization接口的afterPropertiesSet()方法
    @Override
    public void afterPropertiesSet() {
        System.out.println("@afterPropertiesSet: init...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@preDestroy...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy...");
    }

    public void destroyByCustom(){
        System.out.println("destroyByCustom...");
    }
}

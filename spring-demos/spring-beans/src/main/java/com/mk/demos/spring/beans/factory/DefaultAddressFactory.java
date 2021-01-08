package com.mk.demos.spring.beans.factory;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

/**
 * AddressFactory默认实现
 *
 * @author WangChen
 * Created on 2021/1/7 21:07
 * @since 1.0
 */
public class DefaultAddressFactory implements AddressFactory, InitializingBean {

    // 1. @PostConstruct标注方法, @PostConstruct是Java的标准注解(JDK1.6开始有)
    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct: init...");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("@afterPropertiesSet: init...");
    }
}

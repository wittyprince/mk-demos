package com.mk.demos.spring.ioc.container.defaultlistablebeanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author WangChen
 * Created on 2021/4/17 16:38
 * @since
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization-beanName:" + beanName + "-" + bean);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization-beanName:" + beanName + "-" + bean);
        return null;
    }
}

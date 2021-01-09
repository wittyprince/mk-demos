package com.mk.demos.spring.simulation.factory;

/**
 * 模拟BeanFactory-Bean工厂
 *
 * @author WangChen
 * Created on 2021/1/9 18:48
 * @since 1.0
 */
public interface BeanFactory {

    Object getBean(String beanName);
}

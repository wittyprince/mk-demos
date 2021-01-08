package com.mk.demos.spring.beans;

import java.util.ServiceLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.beans.factory.AddressFactory;

/**
 * 特殊方式 Bean 实例化
 *
 * @author WangChen
 * Created on 2021/1/7 21:30
 * @since 1.0
 */
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {
//        String configLocation = "classpath:/META-INF/special-bean-instantiation-context.xml";
//        // 创建BeanFactory容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        // 注册Configuration Class 配置类


        // Java中控制反转
        ServiceLoader<AddressFactory> serviceLoader = ServiceLoader.load(AddressFactory.class, Thread.currentThread().getContextClassLoader());
        for (AddressFactory addressFactory : serviceLoader) {
            System.out.println(addressFactory.createAddress());
        }
    }
}

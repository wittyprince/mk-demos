package com.mk.demos.spring.beans.constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mk.demos.spring.beans.domain.Address;

/**
 * 实例化bean通过构造器constructor之Java注解
 *
 * @author WangChen
 * Created on 2021/1/7 19:35
 * @since 1.0
 */
public class BeanInstantiationByAnnotationDemo {

    public static void main(String [] args){
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册Configuration Class 配置类
        applicationContext.register(BeanInstantiationByAnnotationDemo.class);
        // 启动容器
        applicationContext.refresh();

        System.out.println(applicationContext.getBeansOfType(Address.class));

    }

    @Bean
    public Address address(){
        Address address = new Address();
        address.setId(2L);
        address.setName("shanghai-constructor-annotation");
        return address;
    }
}

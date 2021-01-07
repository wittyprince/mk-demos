package com.mk.demos.spring.beans.constructor;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.beans.domain.Address;

/**
 * bean实例化 demo
 *
 * @author WangChen
 * Created on 2021/1/7 14:25
 * @since 1.0
 */
public class BeanInstantiationByXMLDemo {

    public static void main(String [] args){

//        static String s = "s1";

        String configLocation = "classpath:/META-INF/bean-instantiation-by-xml-context.xml";
        // 创建BeanFactory容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        // 注册Configuration Class 配置类
        // 启动容器

        Map<String, Address> beansOfType = applicationContext.getBeansOfType(Address.class);
        System.out.println(beansOfType);


    }



}

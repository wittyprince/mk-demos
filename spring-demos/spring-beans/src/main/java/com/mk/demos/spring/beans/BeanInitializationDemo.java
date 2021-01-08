package com.mk.demos.spring.beans;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mk.demos.spring.beans.factory.AddressFactory;
import com.mk.demos.spring.beans.factory.DefaultAddressFactory;

/**
 * Bean 实例化 demo
 *
 * @author WangChen
 * Created on 2021/1/8 17:52
 * @since 1.0
 */
public class BeanInitializationDemo {

    public static void main(String [] args){


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();



//        Map<String, DefaultAddressFactory> beansOfType = applicationContext.getBeansOfType(DefaultAddressFactory.class);
//        System.out.println(beansOfType);

        // 1. @PostConstruct标注方法, @PostConstruct是Java的标准注解(JDK1.6开始有)
        // 2. 实现Initialization接口的afterPropertiesSet()方法
        // 3. 自定义初始化方法
		//  3.1 XML配置：<bean init-method="initXXX" …/>
		//  3.2 Java注解：@Bean(initMethod="initXXX")
        //  3.3 Java API：AbstractBeanDefinition#setInitMethodName(String)

        applicationContext.close();
    }

    @Bean(initMethod = "initByCustom", destroyMethod = "destroyByCustom")
    public DefaultAddressFactory addressFactory(){
        return new DefaultAddressFactory();
    }
}

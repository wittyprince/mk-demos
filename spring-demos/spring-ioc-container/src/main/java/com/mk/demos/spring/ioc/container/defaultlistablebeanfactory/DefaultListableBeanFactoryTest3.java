package com.mk.demos.spring.ioc.container.defaultlistablebeanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过ApplicationContext得到DefaultListableBeanFactory
 *
 * DefaultListableBeanFactory 是 默认实现
 *
 * @author WangChen
 * Created on 2021/4/18 10:54
 * @since 1.0
 */
public class DefaultListableBeanFactoryTest3 {

    public static void main(String [] args){
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(DefaultListableBeanFactoryTest3.class);
        AutowireCapableBeanFactory autowireCapableBeanFactory = acac.getAutowireCapableBeanFactory();
        ConfigurableListableBeanFactory configurableListableBeanFactory = acac.getBeanFactory();
        DefaultListableBeanFactory defaultListableBeanFactory = acac.getDefaultListableBeanFactory();
        System.out.println(defaultListableBeanFactory == configurableListableBeanFactory);
        System.out.println(defaultListableBeanFactory == autowireCapableBeanFactory);

        String configLocation = "META-INF/xml-context.xml";
        ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext(configLocation);
        ConfigurableListableBeanFactory configurableListableBeanFactory1 = cpxac.getBeanFactory();
        AutowireCapableBeanFactory autowireCapableBeanFactory1 = cpxac.getAutowireCapableBeanFactory();
        System.out.println(autowireCapableBeanFactory1 == configurableListableBeanFactory1);

        ApplicationContext applicationContext = acac;
        BeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        System.out.println(beanFactory);

        DefaultListableBeanFactory dlbf = (DefaultListableBeanFactory) beanFactory;
        dlbf.registerSingleton("inner", new Inner());
        System.out.println(dlbf.getBean("inner"));
        dlbf.registerBeanDefinition("inner2",
                BeanDefinitionBuilder.genericBeanDefinition(Inner.class).getBeanDefinition());
        System.out.println(dlbf.getBean("inner2"));
    }

}

    class Inner{

    }

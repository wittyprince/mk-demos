package com.mk.demos.spring.beans.constructor;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.demos.spring.beans.domain.Address;

/**
 * 实例化bean通过构造器constructor之Java API
 *
 * @author WangChen
 * Created on 2021/1/7 19:43
 * @since 1.0
 */
public class BeanDefinitionByJavaAPIDemo {

    public static void main(String [] args){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Address.class);
        beanDefinitionBuilder.addPropertyValue("id", 3L);
        beanDefinitionBuilder.addPropertyValue("name", "shanghai-constructor-Java-Api");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
//        BeanDefinitionRegistry beanDefinitionRegistry =
        applicationContext.registerBeanDefinition("shanghai-constructor-Java-Api-beanName", beanDefinition);

        applicationContext.refresh();

        System.out.println(applicationContext.getBeansOfType(Address.class));

        applicationContext.close();



    }
}

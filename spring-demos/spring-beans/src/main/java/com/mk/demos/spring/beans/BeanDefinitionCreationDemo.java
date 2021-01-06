package com.mk.demos.spring.beans;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import com.mk.demos.spring.ioc.container.overview.domain.User;

/**
 * 构建BeanDefinition demo
 *
 * @author WangChen
 * Created on 2021/1/6 13:29
 * @since 1.0
 */
public class BeanDefinitionCreationDemo {

    public static void main(String [] args){
        // 方式一： 通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        definitionBuilder.addPropertyValue("id", 2L);
        definitionBuilder.addPropertyValue("name", "mk");
        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);

        // 方式二： 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 3L);
        // 通过 set MutablePropertyValues 批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);



    }
}

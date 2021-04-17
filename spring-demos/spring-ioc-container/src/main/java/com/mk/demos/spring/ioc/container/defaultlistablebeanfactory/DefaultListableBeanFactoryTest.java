package com.mk.demos.spring.ioc.container.defaultlistablebeanfactory;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import com.mk.demos.spring.model.user.User;

/**
 * DefaultListableBeanFactory 示例
 *
 * @author WangChen
 * Created on 2021/4/17 16:36
 * @since 1.0
 */
public class DefaultListableBeanFactoryTest {

    public static void main(String [] args){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // populate the factory with bean definitions
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
        builder.getBeanDefinition().setBeanClass(User.class);
        builder.addPropertyValue("id", "1");
        builder.addPropertyValue("name", "mk");
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        factory.registerBeanDefinition("user", beanDefinition);

        // now register any needed BeanPostProcessor instances
        factory.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor());
        factory.addBeanPostProcessor(new MyBeanPostProcessor());

        // now start using the factory
        User user = factory.getBean(User.class);
        System.out.println(user);

    }
}

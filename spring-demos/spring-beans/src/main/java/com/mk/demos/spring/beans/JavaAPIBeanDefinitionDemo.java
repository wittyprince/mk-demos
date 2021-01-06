package com.mk.demos.spring.beans;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

import com.mk.demos.spring.ioc.container.overview.domain.User;

/**
 * Java API 方式 注册 BeanDefinition
 *
 * @author WangChen
 * Created on 2021/1/6 21:26
 * @since 1.0
 */
public class JavaAPIBeanDefinitionDemo {

    public static void main(String [] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.refresh();
        applicationContext.register(JavaAPIBeanDefinitionDemo.class);


//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
//        beanDefinitionBuilder.addPropertyValue("id", 4L);
//
//        applicationContext.registerBeanDefinition("mk1", beanDefinitionBuilder.getBeanDefinition());
//
//        System.out.println(applicationContext.getBeansOfType(User.class));


        // 通过 BeanDefinition 注册 API 实现
        // 1.命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext, "mkkk3");
        // 2. 非命名 Bean 的注册方法
        registerUserBeanDefinition(applicationContext);

        System.out.println("User 类型的所有 Beans" + applicationContext.getBeansOfType(User.class));


        applicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1L)
                .addPropertyValue("name", "mkk2");

        // 判断如果 beanName 参数存在时
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

}

package com.mk.demos.spring.beans;

import com.mk.demos.spring.beans.factory.AddressFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mk.demos.spring.ioc.container.overview.domain.User;

/**
 * 注解方式 注册 BeanDefinition
 *
 * @author WangChen
 * Created on 2021/1/6 17:40
 * @since 1.0
 */
public class AnnotationBeanDefinitionDemo {

    private String s = "s";
    public static void main(String [] args){
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(Config.class);

        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);
        System.out.println(user);

        System.out.println(applicationContext.getBean("&addressFactoryBean"));

        applicationContext.close();
    }


    // 注意，这里Config声明为了静态类
    // 如果为非静态类，则applicationContext.register(Config.class);会报错
    // Error creating bean with name 'annotationBeanDefinitionDemo.Config': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.mk.demos.spring.beans.AnnotationBeanDefinitionDemo' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
    // 说明，静态类在spring启动中，已经被加载注册到spring容器中了
     static class Config{

        @Bean
        public User user(){
            User user = new User();
            user.setId(3L);
            user.setName(new AnnotationBeanDefinitionDemo().s);
            return user;
        }

        @Bean
        public AddressFactoryBean addressFactoryBean() {
            return new AddressFactoryBean();
        }
    }

}

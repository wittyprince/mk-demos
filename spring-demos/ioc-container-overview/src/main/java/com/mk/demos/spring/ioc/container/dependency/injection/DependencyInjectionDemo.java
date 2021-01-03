package com.mk.demos.spring.ioc.container.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.ioc.container.dependency.repository.UserRepository;

/**
 * 依赖注入demo
 *
 * @author WangChen
 * Created on 2021/1/3 11:14
 * @since 1.0
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置XML
        // 启动spring
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // 依赖来源一：自定义 Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository);

        // 依赖来源二：依赖注入（內建依赖）
        // 注意这里是通过autowire=byType方式时，才可以通过UserRepository#setBeanFactory方法注入
        System.out.println(userRepository.getBeanFactory());

        // 依赖查找（错误）
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        // ObjectFactory<ApplicationContext> != ObjectFactory<BeanFactory> == BeanFactory beanFactory
        ApplicationContext applicationContext = userRepository.getObjectFactory().getObject();
        System.out.println(applicationContext == beanFactory); // true

        System.out.println(userRepository.getBeanFactory() == userRepository.getObjectFactoryBeanFactory().getObject()); // true

        System.out.println(userRepository.getUserObjectFactory());
        // 这句话需要有bean id="objectFactory1" class="org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean"显示定义
        // 因为autowire=byType, 所以id="objectFactory1"不影响
        System.out.println(beanFactory.getBean(ObjectFactory.class));
    }
}

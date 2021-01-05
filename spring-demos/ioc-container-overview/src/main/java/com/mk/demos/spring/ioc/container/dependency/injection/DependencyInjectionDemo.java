package com.mk.demos.spring.ioc.container.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // org.springframework.context.support.ClassPathXmlApplicationContext@c4437c4, started on Tue Jan 05 21:28:43 CST 2021
        System.out.println("applicationContext: " + applicationContext);
        // org.springframework.beans.factory.support.DefaultListableBeanFactory@3fb6a447
        System.out.println("applicationContext.getBeanFactory: "+ ((ClassPathXmlApplicationContext) applicationContext).getBeanFactory());

        // 依赖来源一：自定义 Bean
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository);

        // 依赖来源三：依赖注入（內建依赖）
        // 注意这里是通过autowire=byType方式时，才可以通过UserRepository#setBeanFactory方法注入
        // org.springframework.beans.factory.support.DefaultListableBeanFactory@3fb6a447
        System.out.println("userRepository.getBeanFactory: "+ userRepository.getBeanFactory());
        // org.springframework.context.support.ClassPathXmlApplicationContext@c4437c4, started on Tue Jan 05 21:35:44 CST 2021
        System.out.println("userRepository.getApplicationContext: " + userRepository.getApplicationContext());
        System.out.println(applicationContext == userRepository.getBeanFactory()); // false

        // 依赖查找（错误）
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        // ObjectFactory<ApplicationContext> != ObjectFactory<BeanFactory> == BeanFactory beanFactory
        ApplicationContext objectFactoryApplicationContext = userRepository.getObjectFactoryApplicationContext().getObject();
        System.out.println(objectFactoryApplicationContext == applicationContext); // true
        // org.springframework.context.support.ClassPathXmlApplicationContext@c4437c4, started on Tue Jan 05 20:55:34 CST 2021
        System.out.println("objectFactoryApplicationContext: " + objectFactoryApplicationContext);

        System.out.println(userRepository.getBeanFactory() == userRepository.getObjectFactoryBeanFactory().getObject()); // true

        // org.springframework.beans.factory.support.DefaultListableBeanFactory$DependencyObjectProvider@131276c2
        System.out.println("UserObjectFactory: " + userRepository.getUserObjectFactory());
        // 这句话需要有bean id="objectFactory1" class="org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean"显示定义
        // 因为autowire=byType, 所以id="objectFactory1"不影响
        // org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean$TargetBeanObjectFactory@7f13d6e
        System.out.println("ObjectFactory.class: " + applicationContext.getBean(ObjectFactory.class));

        // 依赖来源二：容器內建 Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);
    }
}

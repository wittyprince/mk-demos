package com.mk.demos.spring.ioc.container.overview.container;

import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mk.demos.spring.ioc.container.overview.domain.User;

/**
 * ApplicationContext作为IoC容器demo
 *
 * @author WangChen
 * Created on 2021/1/5 22:23
 * @since 1.0
 */
public class ApplicationContextAsIoCContainerDemo {

    public static void main(String [] args){
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationContextAsIoCContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(ApplicationContextAsIoCContainerDemo.class);
        // 启动应用上下文，refresh方法是启动上下文的唯一途径
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupCollectionByType(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * 通过 Java 注解的方式，定义了一个 Bean
     */
    @Bean
    public User user(){
        User user = new User();
        user.setId(1L);
        user.setName("mk");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory){
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }
    }
}

package com.mk.demos.spring.ioc.container.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.model.User;

/**
 * xml 方式 配置 ApplicationContext
 *
 * @author WangChen
 * Created on 2021/4/9 14:56
 * @since 1.0
 */
public class ClassPathXmlApplicationContextTest {

    public static void main(String [] args){
        // 方式一：相对路径 (推荐)
        String configLocation = "META-INF/xml-context.xml";
        // 方式二：绝对路径
        // String configLocation = "classpath:/META-INF/xml-context.xml";

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);

        User user = applicationContext.getBean("user", User.class);

        System.out.println(user);

        // name 属性可以使用逗号, 分号; 空格 分隔，定义不同的别名
        User dUser = applicationContext.getBean("dUser", User.class);
        System.out.println("dUser: " + dUser);

        // 使用alias命名别名
        User myUser = applicationContext.getBean("myUser", User.class);
        System.out.println("myUser: " + myUser);
    }
}

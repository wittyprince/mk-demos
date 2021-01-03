package com.mk.demos.spring.ioc.container.dependency.lookup;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.ioc.container.dependency.annotation.Super;
import com.mk.demos.spring.ioc.container.dependency.domain.Account;
import com.mk.demos.spring.ioc.container.dependency.domain.User;

/**
 * 依赖查找demo
 * 1. 通过名称的方式来查找
 *
 *
 * @author WangChen
 * Created on 2021/1/2 17:39
 * @since 1.0
 */
public class DependencyLookupDemo {

    public static void main(String[] args) throws Exception {

        // 配置 XML 配置文件
        // 启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");


        lookupInRealTime(beanFactory);

        lookupInLazy(beanFactory);

        // 按照类型查找
        lookupByType(beanFactory, User.class);
        // 按照类型查找结合对象
        lookupCollectionByType(beanFactory);
        // 通过注解查找对象
        lookupByAnnotationType(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有的 User 集合对象：" + users);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory){
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }
    }

    /**
     * 根据Bean类型查找
     */
    private static void lookupByType(BeanFactory beanFactory, Class<?> clz) {
        Object bean = beanFactory.getBean(clz);
        System.out.println("lookupByType:" + bean);
    }

    /**
     * 实时查找
     */
    private static void lookupInRealTime(BeanFactory beanFactory){
//        User user = beanFactory.getBean(User.class);
        //TODO BeanFactory#getBean(String name);源码分析
        Object user = beanFactory.getBean("user");
//        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
//        Map<String, Object> accountMap = new HashMap<>();
//        accountMap.put("id", 1);
//        accountMap.put("accountNo", "112123");
//        Object account = beanFactory.getBean("account", accountMap);
//        System.out.println("account:" + account);
    }

    /**
     * 延迟查找
     */
    private static void lookupInLazy(BeanFactory beanFactory){
        // 借助 ObjectFactoryCreatingFactoryBean 实现延迟查找
        // 这里得到的objectFactory只是一个Bean的查找代理
        // 只有当 getObject() 方法时，才会触发 Bean 实例化等生命周期
        //TODO 在XML中定义的是ObjectFactoryCreatingFactoryBean类型，这里得到的为什么是ObjectFactory类型？
        /**
         * 答：
         * 这个是 BeanFactory 实现决定，当 name 关联的 Bean 为 FactoryBean，实际返回的对象是 FactoryBean#getObject()，
         * 请参考 org.springframework.beans.factory.support.AbstractBeanFactory#getObjectForBeanInstance 方法。
         *
         * ObjectFactoryCreatingFactoryBean 是 ObjectFactory 和 FactoryBean 组合形式，通过 FactoryBean 注册 ObjectFactory
         *
         */
        //TODO 延迟查找的好处是什么？
        //TODO 得到
        ObjectFactory<Account> objectFactory = (ObjectFactory<Account>) beanFactory.getBean("objectFactory");
//        Account account = objectFactory.getObject();
//        System.out.println("account:" + account);
    }
}

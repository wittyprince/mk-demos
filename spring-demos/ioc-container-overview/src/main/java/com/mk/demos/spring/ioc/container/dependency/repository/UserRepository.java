package com.mk.demos.spring.ioc.container.dependency.repository;

import java.util.Collection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import com.mk.demos.spring.ioc.container.dependency.domain.User;

/**
 * user 仓库
 *
 * @author WangChen
 * Created on 2021/1/3 11:11
 * @since 1.0
 */
public class UserRepository {

    private Collection<User> users;

    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> objectFactory;// 这里通过getObject得到的就是applicationContext,也就是ClassPathXmlApplicationContext

    private ObjectFactory<BeanFactory> objectFactoryBeanFactory;// 这里通过getObject得到的就是line22行的BeanFactory beanFactory

    private ObjectFactory<User> userObjectFactory;// 这里得到的是DefaultListableBeanFactory$DependencyObjectProvider@79be0360,即user的代理引用


    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public ObjectFactory<BeanFactory> getObjectFactoryBeanFactory() {
        return objectFactoryBeanFactory;
    }

    public void setObjectFactoryBeanFactory(ObjectFactory<BeanFactory> objectFactoryBeanFactory) {
        this.objectFactoryBeanFactory = objectFactoryBeanFactory;
    }

    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}

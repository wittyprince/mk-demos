package com.mk.demos.spring.ioc.container.overview.container;

import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.mk.demos.spring.ioc.container.overview.domain.User;

/**
 * BeanFactory 作为 IoC容器
 *
 * @author WangChen
 * Created on 2021/1/5 22:06
 * @since 1.0
 */
public class BeanFactoryAsIoCContainerDemo {

    public static void main(String[] args) {
        // 定义BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        beanFactory.
        // 加载配置
//        BeanDefinition beanDefinition = new B
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // ClassPath 路径
        String location = "/META-INF/dependency-lookup-context.xml";
        // XML 配置文件
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);
        System.out.println(beanDefinitionsCount);
        // 依赖查找集合对象
        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory){
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }
    }

}

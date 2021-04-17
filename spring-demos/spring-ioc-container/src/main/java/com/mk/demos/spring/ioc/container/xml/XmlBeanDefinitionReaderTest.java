package com.mk.demos.spring.ioc.container.xml;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import com.mk.demos.spring.model.user.User;

/**
 * xml bean definition reader
 *
 * @author WangChen
 * Created on 2021/4/9 15:28
 * @since 1.0
 */
public class XmlBeanDefinitionReaderTest {

    public static void main(String [] args){
        String configLocation = "META-INF/xml-context.xml";
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(configLocation);
        // 启动spring应用上下文
        context.refresh();
        User user = context.getBean("user", User.class);
        System.out.println(user);
        // 关闭spring应用上下文
        context.close();
    }
}

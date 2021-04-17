package com.mk.demos.spring.ioc.container.defaultlistablebeanfactory;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import com.mk.demos.spring.model.user.Profile;
import com.mk.demos.spring.model.user.User;

/**
 * DefaultListableBeanFactory 示例
 *
 * @author WangChen
 * Created on 2021/4/17 19:30
 * @since 1.0
 */
public class DefaultListableBeanFactoryTest2 {

    public static void main(String [] args){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("META-INF/xml-context.xml");
        Profile profile = factory.getBean(Profile.class);
        System.out.println(profile);

        // bring in some property values from a Properties file
        PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
        // cfg.setLocation(new FileSystemResource("jdbc.properties"));

        // now actually do the replacement
        // cfg.postProcessBeanFactory(factory);
    }
}

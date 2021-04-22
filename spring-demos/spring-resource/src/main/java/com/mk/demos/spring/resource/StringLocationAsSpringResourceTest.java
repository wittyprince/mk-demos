package com.mk.demos.spring.resource;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * spring resource 示例
 * org.springframework.core.io.Resource 类型的 property属性，
 * 可以直接把String类型的location解析为Resource
 *
 * @author WangChen
 * Created on 2021/4/22 10:04
 * @since 1.0
 */
public class StringLocationAsSpringResourceTest {

    public static void main(String [] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        String location = "META-INF/xml-context.xml";
        context.setConfigLocation(location);
        context.refresh();

        MyBean myBean = context.getBean(MyBean.class);
        ClassPathResource template = (ClassPathResource) myBean.getTemplate();
        System.out.println((char)template.getInputStream().read());

        context.close();
    }
}

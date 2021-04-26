package com.mk.demos.spring.propertyeditor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义PropertyEditor
 * 通过ExoticTypeEditor，把输入的字符串aNameForExoticType解析为ExoticType类型，并转换为大写。
 * @author WangChen
 * Created on 2021/4/22 20:08
 * @since 1.0
 */
public class CustomPropertyEditorTest {

    public static void main(String [] args){
        String configLocation = "META-INF/propertyeditor-context.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        DependsOnExoticType dependsOnExoticType = context.getBean(DependsOnExoticType.class);
        System.out.println(dependsOnExoticType.getType().getName());
    }
}

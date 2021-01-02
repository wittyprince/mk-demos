package com.mk.demos.spring.ioc.java.beans;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * BeanInfo 示例
 *
 * @author WangChen
 * Created on 2021/1/2 15:45
 * @since 1.0
 */
public class BeanInfoDemo {


    public static void main(String[] args) throws IntrospectionException {

        // 通过Introspector(Java5提供)得到Person.class的bean info信息
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        System.out.println("-----------------");
        // beanDescriptor bean描述
        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
        System.out.println("beanDescriptor: " + beanDescriptor);

        // PropertyDescriptor属性描述
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors){
            System.out.println(descriptor.toString());
        }
        System.out.println("-----------------");

        // 得到属性后，可以对属性进行操作
        // PropertyDescriptor允许对属性添加编辑器PropertyEditor
        // 用途：
        // 1. GUI中 text(String) -> PropertyType
        // 2. java bean中，name -> String
        //                age -> Integer
        Stream.of(propertyDescriptors).forEach(
                propertyDescriptor -> {
                    System.out.println(propertyDescriptor);
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    propertyDescriptor.getDisplayName();
                    String propertyName = propertyDescriptor.getName();
                    if ("age".equals(propertyName)){// 为age字段添加PropertyEditor
                        // String -> Integer
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerEditor.class);
//                        Object value = propertyDescriptor.getValue(propertyName);
//                        System.out.println(value.getClass());
                    }
                }
        );
    }

    static class StringToIntegerEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException{
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}

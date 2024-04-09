package com.mk.demos.java.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Introspector Test
 *
 * @author WangChen
 * Created on 2024/4/9
 * @since 1.0
 */
public class IntrospectorTest {

    public static void main(String[] args) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("wc");
        userInfo.setAge(18);
        getProperty(userInfo, "age"); // get age:18
        setProperty(userInfo, "age", 20); // set age:20
        getProperty(userInfo, "age"); // get age:20

        getPropertyByIntrospector(userInfo, "name"); // get name:wc
        setPropertyByIntrospector(userInfo, "name", "wcc"); // set name:wcc
        getPropertyByIntrospector(userInfo, "name"); // get name:wcc
    }

    /**
     * 获取属性值
     * 直接通过属性的描述器java.beans.PropertyDescriptor类，来访问属性的getter/setter 方法,
     * 然后我们就可以通过反射机制来调用这些方法。
     *
     * @param userInfo BeanInfo信息
     * @param propertyName 属性名
     * @throws Exception 异常
     */
    public static void getProperty(UserInfo userInfo, String propertyName) throws Exception {
        PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, UserInfo.class);
        Method readMethod = descriptor.getReadMethod();
        Object invoke = readMethod.invoke(userInfo);
        System.out.println("get " + propertyName + ":" + invoke.toString());
    }

    /**
     * 设置属性值
     * 直接通过属性的描述器java.beans.PropertyDescriptor类，来访问属性的getter/setter 方法,
     * 然后我们就可以通过反射机制来调用这些方法。
     *
     * @param userInfo BeanInfo信息
     * @param propertyName 属性名
     * @param propertyValue 属性值
     * @throws Exception 异常
     */
    public static void setProperty(UserInfo userInfo, String propertyName, Object propertyValue) throws Exception {
        PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, UserInfo.class);
        Method writeMethod = descriptor.getWriteMethod();
        writeMethod.invoke(userInfo, propertyValue);
        System.out.println("set " + propertyName + ":" + propertyValue.toString());
    }

    /**
     * 通过Introspector获取属性值
     * 通过类 Introspector 来获取某个对象的 BeanInfo 信息，
     * 然后通过 BeanInfo 来获取属性的描述器（ PropertyDescriptor ），
     * 通过这个属性描述器就可以获取某个属性对应的 getter/setter 方法，
     * 然后我们就可以通过反射机制来调用这些方法。
     *
     * @param userInfo BeanInfo信息
     * @param propertyName 属性名
     * @throws Exception 异常
     */
    public static void getPropertyByIntrospector(UserInfo userInfo, String propertyName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        if (descriptors != null) {
            for (PropertyDescriptor descriptor : descriptors) {
                if (descriptor.getName().equals(propertyName)) {
                    Method readMethod = descriptor.getReadMethod();
                    Object invoke = readMethod.invoke(userInfo);
                    System.out.println("get " + propertyName + ":" + invoke.toString());
                    break;
                }
            }
        }
    }

    /**
     * 通过Introspector设置属性值
     * 通过类 Introspector 来获取某个对象的 BeanInfo 信息，
     * 然后通过 BeanInfo 来获取属性的描述器（ PropertyDescriptor ），
     * 通过这个属性描述器就可以获取某个属性对应的 getter/setter 方法，
     * 然后我们就可以通过反射机制来调用这些方法。
     *
     * @param userInfo BeanInfo信息
     * @param propertyName 属性名
     * @param propertyValue 属性值
     * @throws Exception 异常
     */
    public static void setPropertyByIntrospector(UserInfo userInfo, String propertyName, Object propertyValue) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
        PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();
        if (proDescrtptors != null) {
            for (PropertyDescriptor propDesc : proDescrtptors) {
                if (propDesc.getName().equals(propertyName)) {
                    Method writeMethod = propDesc.getWriteMethod();
                    writeMethod.invoke(userInfo, propertyValue);
                    System.out.println("set " + propertyName + ":" + propertyValue.toString());
                    break;
                }
            }
        }
    }
}

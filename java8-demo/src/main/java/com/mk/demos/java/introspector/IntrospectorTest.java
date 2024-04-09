package com.mk.demos.java.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Introspector Test
 *
 * 主要参考：java.beans.Introspector中的类注释
 * Introspector是Java语言对JavaBean的 properties，events 及 methods 一种缺省或默认处理方法。
 *
 * JavaBean是一种特殊的类（也可以说是普通）。
 * 我们又通常把javabean的实例对象称之为值对象（Value Object）,因为这些bean中通常只有一些信息字段和存储方法，没有功能性方法。
 * 一个JavaBean类可以不当JavaBean用，而当成普通类 用。
 * JavaBean实际就是一种规范，当一个类满足这个规范，这个类就能被其它特定的类调用。
 * 一个类被当作javaBean使用时，JavaBean的 属性是根据方法名推断出来的，
 * 它根本看不到java类内部的成员变量(javabean的成员变量通常都是私有private的)。
 * JavaBean的属性是通过方法来定义的，而不是通过变量来定义的。这些方法是getXXX()和setXXX()方法。
 *
 * 例如在某类中有属性name, 那我们可以通过 getName,setName来得到其值或者设置新的值。
 * 通过 getName/setName来访问 name属性，这就是默认的规则。
 * Java JDK中提供了一套 API 用来访问某个属性的 getter/setter 方法(通过这些API可以使你不需要了解这个规则)，这就是内省。
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
        for (PropertyDescriptor descriptor : descriptors) {
            if (descriptor.getName().equals(propertyName)) {
                Method readMethod = descriptor.getReadMethod();
                Object invoke = readMethod.invoke(userInfo);
                System.out.println("get " + propertyName + ":" + invoke.toString());
                break;
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

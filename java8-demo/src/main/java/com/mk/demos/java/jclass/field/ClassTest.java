package com.mk.demos.java.jclass.field;

import java.lang.reflect.Field;

/**
 * class test
 *
 * @author WangChen
 * Created on 2019/12/22 11:01
 * @since 1.0
 */
public class ClassTest {

    private static Class<A> aClass = A.class;
    private static Class<B> bClass = B.class;

    public static void main(String [] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {

        A a = ClassTest.aClass.newInstance();
        a.call();

        B anotherObject = bClass.newInstance();
        anotherObject.speak();

        System.out.println("1: " + ClassTest.aClass.newInstance().getInner()); // time flies.

        Field privateFieldInA = ClassTest.aClass.getDeclaredField("inner");
        privateFieldInA.setAccessible(true);
        privateFieldInA.set(a, "world changed."); // 这里仅仅改变的是A的实例对象a的privateFieldInA的值
        System.out.println(a.getInner()); // world changed.

        System.out.println("2: " + ClassTest.aClass.newInstance().getInner()); // A的新实例，其值依然是A的原始值
    }

}


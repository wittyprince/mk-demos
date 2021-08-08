package com.mk.demos.java.jclass;

import java.util.List;
import java.util.Map;

/**
 * ClassNameTest
 *
 * name:            调用Class.forName(String name, boolean initialize, ClassLoader loader)
 *                  动态加载class类的时候所使用的name，须保证在同一个ClassLoader内class类名唯一
 * CanonicalName：   用在import语句中标识的name，
 *
 * @author WangChen
 * Created on 2021/1/22 21:15
 * @since 1.0
 */
public class ClassNameTest {

    public static void main(final String... arguments) {
        printNamesForClass(int.class, "int.class (primitive)");
        printNamesForClass(Integer.class, "Integer.class (boxed)");
        printNamesForClass(String.class, "String.class (ordinary class)");
        printNamesForClass(List.class, "List.class (list class)");
        printNamesForClass(Map.class, "Map.class (map class)");
        printNamesForClass(int[].class, "int[].class (primitive)");
        printNamesForClass(Integer[].class, "Integer[].class (boxed)");
        printNamesForClass(String[].class, "String[].class (ordinary)");
        printNamesForClass(java.util.HashMap.SimpleEntry.class,
                "java.util.HashMap.SimpleEntry.class (nested class)");
        printNamesForClass(new java.io.Serializable() {}.getClass(),
                "new java.io.Serializable(){}.getClass() (anonymous inner class)");
    }

    private static void printNamesForClass(final Class<?> clazz, final String label) {
        System.out.println(label + ":");
        System.out.println(" name():          " + clazz.getName());         // 类名：通过ClassLoader来加载类时使用的名字
        System.out.println(" canonicalName(): " + clazz.getCanonicalName());// 规范名称：be used in an import statement
        System.out.println(" simpleName():    " + clazz.getSimpleName());   // 简单名称：去掉包名的类名
        System.out.println(" typeName():      " + clazz.getTypeName());     // added in Java 8：纯粹提供信息，没有合同价值(规约价值)
        System.out.println();
    }
}

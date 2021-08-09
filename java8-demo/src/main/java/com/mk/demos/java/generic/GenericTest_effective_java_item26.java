package com.mk.demos.java.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 泛型
 *
 * @author WangChen
 * Created on 2021/8/8 21:40
 * @since 0.1
 */
public class GenericTest_effective_java_item26 {

    public static void main(String [] args){
        // List  vs List<Object>
        List            list1 = new ArrayList();
        list1.add(1);
        list1.add("s");
        List<Object>    list2 = new ArrayList<>();
        list2.add(1);
        list2.add("s");
        // List 是 原始类型的，可以放任意类型的对象
        // List<Object> 是泛型的List，可以放任意对象

        // 泛型有子类型的概念
        List<String> stringList = new ArrayList<>();
        list1 = stringList; // 可以
//        list2 = stringList; // 编译报错
        // List<String> 是 原始类型List的子类型，而不是List<Object>的子类型


        // 无界通配符
        Set<?> set = new HashSet<>();
//        set.add(1);     // 编译报错
        set.add(null);  // 只能讲null放入无界通配符集合中


        // 例外：
        // 1. 必须在类字面量中使用原始类型
        //    即：List.class，String[].class 和 int.class 都是合法的，
        //    但是 List<String>.class 和 List<?>.class 不是。
        // 2. instanceof 运算符
        //    一旦确定 o 是一个 Set，就必须将其强制转换为通配符类型 Set<?>，而不是原始类型 Set。
        Object o = new Object();
        if (o instanceof Set) { // Raw type
            Set<?> s = (Set<?>) o; // Wildcard type
            // ...
        }



    }
}

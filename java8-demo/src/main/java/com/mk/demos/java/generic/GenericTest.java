package com.mk.demos.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 *
 * @author WangChen
 * Created on 2021/7/10 18:42
 * @since 1.0
 */
public class GenericTest {
    public static void main(String [] args){
        List<String>    list1 = new ArrayList<>();
        List            list2 = new ArrayList();
        List<Object>    list3 = new ArrayList<>();
        List<?>         list4 = new ArrayList<>();
//        unsafeAdd(list1, Integer.valueOf("1")); // 编译错误
//        System.out.println(list1.get(0));
        unsafeAdd(list2, Integer.valueOf("1"));
        System.out.println(list2.get(0));
        unsafeAdd(list3, Integer.valueOf("1"));
        System.out.println(list3.get(0));
//        unsafeAdd(list4, Integer.valueOf("1")); // 编译错误
//        System.out.println(list4.get(0));

        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // Throws ArrayStoreException

        // Won't compile!
//        List<Object> ol = new ArrayList<Long>(); // Incompatible types
//        ol.add("I don't fit in"); // 编译错误


    }

    private static void unsafeAdd(List<Object> list, Object o){
        list.add(o);
    }
}

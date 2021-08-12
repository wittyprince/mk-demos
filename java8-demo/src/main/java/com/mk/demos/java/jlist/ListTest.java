package com.mk.demos.java.jlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * list test
 *
 * @author WangChen
 * Created on 2021/8/12 11:20
 * @since 0.1
 */
public class ListTest {

    public static void main(String [] args){
        // Arrays.asList 返回的只是一个List的视图，不能对其进行添加add或移除remove操作
        List<String> stringList = Arrays.asList("a", "b");
        stringList.forEach(System.out::println);

//        stringList.add("c"); // UnsupportedOperationException
//        stringList.forEach(System.out::println);

//        stringList.remove("a"); // UnsupportedOperationException
//        stringList.forEach(System.out::println);

        List<String> list = new ArrayList<>(stringList);
        list.add("c");
        list.forEach(System.out::println);

        list.remove("a");
        list.forEach(System.out::println);

    }
}

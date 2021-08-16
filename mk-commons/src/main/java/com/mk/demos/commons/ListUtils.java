package com.mk.demos.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * List 工具类
 *
 * @author WangChen
 * Created on 2021/8/16 14:34
 * @since 0.1
 */
public class ListUtils {


    /**
     * Possible heap pollution from parameterized vararg type
     * 堆污染: 指一个变量被指向另外一个不是相同类型的变量
     */
    public static <T> List<T> of1(T... t){
        return new ArrayList<>(Arrays.asList(t));
    }

    /**
     * Possible heap pollution from parameterized vararg type
     * 堆污染: 指一个变量被指向另外一个不是相同类型的变量
     */
    @SafeVarargs
    public static <T> List<T> of(T... t){
        return Stream.of(t).collect(Collectors.toList());
    }

}

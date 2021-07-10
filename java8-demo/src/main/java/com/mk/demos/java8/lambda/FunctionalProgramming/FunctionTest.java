package com.mk.demos.java8.lambda.FunctionalProgramming;

import java.awt.*;
import java.util.function.Predicate;

/**
 * 函数式编程
 *
 * @author WangChen
 * Created on 2021/7/10 22:17
 * @since 0.1
 */
public class FunctionTest {

    public static void main(String [] args){
        Predicate<Integer> p = x -> x > 5; // 可以看做相当于Holder的概念
//        MyPredicate<Integer> m = x -> x > 5; // 无法编译通过
    }
}

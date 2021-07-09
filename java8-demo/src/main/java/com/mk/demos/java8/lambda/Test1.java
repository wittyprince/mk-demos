package com.mk.demos.java8.lambda;

import java.awt.*;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author WangChen
 * Created on 2021/7/8 14:18
 * @since 1.0
 */
public class Test1 {

    public static void main(String [] args){
        Predicate<Integer> atLeast5 = x -> x > 5;

        BinaryOperator<Long> add = (x, y) -> x + y;

    }
}

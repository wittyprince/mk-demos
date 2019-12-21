package com.mk.demos.java;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Unmodifiable collections
 *
 * @author WangChen
 * Created on 2019/12/21 18:21
 * @since 1.0
 */
public class UnmodifiableTest {

    public static void main(String [] args){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        Set<Integer> newNumbers = Collections.unmodifiableSet(numbers);
        System.out.println(newNumbers);// [1]
        numbers.add(2);
        System.out.println(newNumbers);// [1, 2]

    }
}

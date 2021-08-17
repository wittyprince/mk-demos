package com.mk.demos.java8.lambda.FunctionalProgramming.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 第五章练习Fibonacci
 *
 * @author WangChen
 * Created on 2021/7/12 10:43
 * @since 0.1
 */
public class Fibonacci {

    private final Map<Integer,Long> cache;

    public Fibonacci() {
        cache = new HashMap<>();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }

    public long fibonacci(int x) {
//        return cache.computeIfAbsent(x, (a) -> {});
        return 0;
    }
}

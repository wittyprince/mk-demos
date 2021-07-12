package com.mk.demos.java8.lambda.FunctionalProgramming.exercise;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 第五章的GroupBying
 *
 * @author WangChen
 * Created on 2021/7/12 10:13
 * @since 0.1
 */
public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>>{

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return null;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return null;
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}

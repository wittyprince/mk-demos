package com.mk.demos.java8.lambda.FunctionalProgramming.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 第五章的自定义GroupingBy收集器实现Collectors.groupingBy功能
 *
 * @author WangChen
 * Created on 2021/7/12 10:13
 * @since 0.1
 */
public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>>{

    private final static Set<Characteristics> characteristics = new HashSet<>();
    static {
        characteristics.add(Characteristics.IDENTITY_FINISH);
    }

    private final Function<? super T, ? extends K> classifier;
    public GroupingBy(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return () -> new HashMap<>();
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (acc, t) -> {
            K k = classifier.apply(t);
            List<T> ts = acc.get(k);
            if (ts == null){
                ts = new ArrayList<>();
            }
            ts.add(t);
            acc.put(k, ts);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
//        return (x, y) -> {
//            x.putAll(y); // 使用putAll是错误的
//            return x;
//        };
        return (m1, m2) -> {
            m2.forEach(
                    (k2, v2) -> {
                        m1.merge(k2, v2,
                                (value1, value2) -> {
                                    value1.addAll(value2);
                                    return value1;
                                });
                    }
            );
            return m1;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return a -> a;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }
}

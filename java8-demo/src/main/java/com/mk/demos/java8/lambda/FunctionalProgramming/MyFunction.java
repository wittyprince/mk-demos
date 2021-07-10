package com.mk.demos.java8.lambda.FunctionalProgramming;

import java.util.Objects;
import java.util.function.Function;

/**
 * Function 测试compose方法
 *
 * @author WangChen
 * Created on 2021/7/10 20:20
 * @since 1.0
 */
public interface MyFunction<T, R> {

    R apply(T t);

    // <V> 是参数列表，并不是返回值；该compose方法返回值是Function<V, R>
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }
}

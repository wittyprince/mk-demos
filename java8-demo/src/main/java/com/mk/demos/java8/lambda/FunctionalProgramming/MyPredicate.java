package com.mk.demos.java8.lambda.FunctionalProgramming;

/**
 * Predicate 测试
 *
 * @author WangChen
 * Created on 2021/7/10 22:11
 * @since 1.0
 */
public interface MyPredicate {

    // 类型参数T, 是放在类名后面，如java.util.function.Predicate
    // 还是放在 方法名前，如此例中 ？？？
    // 参考代码为：
    //          Predicate<Integer> p = x -> x > 5; // 可以编译通过
    //          MyPredicate m =  // 无法处理
    <T> boolean test(T t);
}

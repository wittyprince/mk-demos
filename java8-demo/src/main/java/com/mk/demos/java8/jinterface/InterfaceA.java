package com.mk.demos.java8.jinterface;

/**
 * default method (缺省方法, 默认方法)
 * 目的: 在java8中新增 default method 的目的是 给接口中增加方法, 而又不会造成早期实现了该接口的类出现编译错误
 * 风险:
 *      1. 如果接口中新增的方法 与 实现类中有相同的方法签名(方法名 + 参数)相同, 但是返回值不同时, 则会出现编译错误
 *      2. Effective Java third edition 中 第21条中 Collection接口新增的removeIf()方法 与 实现类org.apache.commons.collections4.Collection.SynchronizedCollection
 *          与 java.util.Collections.synchronizedCollection
 *
 *
 * @author WangChen
 * Created on 2019/12/14 21:52
 * @since 1.0
 */
public interface InterfaceA {

    void print();

    double plus(double d1, double d2);

    default double minus(double d1, double d2){
        return d1 - d2;
    }

    default double times(double d1, double d2){
        return  d1 * d2;
    }
}

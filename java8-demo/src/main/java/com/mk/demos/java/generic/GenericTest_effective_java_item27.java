package com.mk.demos.java.generic;

/**
 * GenericTest_effective_java_item27
 *
 * 消除unchecked警告
 *
 * @author WangChen
 * Created on 2021/8/9 15:36
 * @since 0.1
 */
public class GenericTest_effective_java_item27 {

    // 1. 消除unchecked警告
    // 力求消除所有 unchecked 警告
    // 如果不能消除警告，但是可以证明引发警告的代码是类型安全的，那么（并且只有在那时）使用 SuppressWarnings("unchecked") 注解来抑制警告
    // 总是在尽可能小的范围上使用 SuppressWarnings 注解
    // 每次使用 SuppressWarnings("unchecked") 注解时，要添加一条注释，说明这样做是安全的。

}

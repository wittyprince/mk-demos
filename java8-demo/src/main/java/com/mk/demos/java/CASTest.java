package com.mk.demos.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * compare and swap/set
 * 三个值：内存值V，期望值A，需要更新的值B
 * 如果内存值V == A，那么把内存值V更新为B
 *
 * @author WangChen
 * Created on 2020/4/14 19:17
 * @since 1.0
 */
public class CASTest {

    public static void main(String [] args){
        AtomicInteger atomicInteger = new AtomicInteger(1);

        boolean b = atomicInteger.compareAndSet(1, 3);
        System.out.println(atomicInteger + "_" + b);// 3_true

        boolean c = atomicInteger.compareAndSet(2, 5);
        System.out.println(atomicInteger + "_" + c);// 3_false
    }
}

package com.mk.demos.java8.stream;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 斐波那契数列
 *
 * 用 iterate 方法生成斐波纳契元组序列中的前20个元素
 *
 * @author WangChen
 * Created on 2019/12/19 20:51
 * @since 1.0
 */
public class Fibonacci {

    public static void main(String [] args){
        //  new int[]{0,1} 就代表了斐波纳契序列(0, 1)中的第一个元素
        // Stream.iterate()里的参数方法是不改变状态的
        // 所以应该使用iterate()方法而不应该使用generate()方法
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));


        // Stream.generate()里的参数方法是可以改变状态的
        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }
}

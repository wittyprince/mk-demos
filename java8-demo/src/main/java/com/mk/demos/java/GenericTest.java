package com.mk.demos.java;

/**
 * 泛型
 *
 * @author WangChen
 * Created on 2021/2/25 21:40
 * @since 1.0
 */
public class GenericTest<T> {

    public static void main(String [] args){
        Integer a = 222;
        Long b = 333L;
        Integer result = get(a, b);
    }

    /**
     * 注意：这里的String，并非java.lang.String，仅是一个标识符而已，
     *  Alibaba 也是类似
     */
    static<String, S, Alibaba> String get(String string, Alibaba alibaba){
        return string;
    }
}

package com.mk.demos.java8.chapter2;

import java.util.stream.Stream;

/**
 * @author WangChen
 * Created on 2019/4/9 15:55
 * @since
 */
public class Test02 {

    public static void main(String[] args){

        Stream<String> abc = Stream.of("a", "b", "c");
        Stream<String> generate = Stream.generate(() -> "abc");
    }
}

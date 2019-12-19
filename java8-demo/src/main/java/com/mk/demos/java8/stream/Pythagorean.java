package com.mk.demos.java8.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * pythagorean Triples 勾股定理（毕达哥拉斯定理）
 *
 * @author WangChen
 * Created on 2019/12/19 20:22
 * @since 1.0
 */
public class Pythagorean {

    public static void main(String [] args){
        // Bad return type in lambda expression: int[] cannot be converted to int
        /*IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(3*3 + b*b) % 1 == 0)
//                .boxed()
                .map(b -> new int[]{3, b, (int) Math.sqrt(3 * 3 + b * b)});*/

        Stream<int[]> stream1 = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(3 * 3 + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{3, b, (int) Math.sqrt(3 * 3 + b * b)});
//        stream1.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        Stream<int[]> stream = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(3 * 3 + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{3, b, (int) Math.sqrt(3 * 3 + b * b)});/*.forEach(System.out::println)*/
//        stream.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        Stream<int[]> pythagoreanTriples =
//        Stream<Stream<int[]>> streamStream =
                IntStream.rangeClosed(1, 100).boxed()
                .flatMap(
//                .map(
                        a -> IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
//        streamStream.flatMap()
        pythagoreanTriples
                .limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

//        Stream.of()

    }
}

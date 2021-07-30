package com.mk.demos.java8.lambda;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 滑动窗口
 *
 * @author WangChen
 * Created on 2021/7/30 17:34
 * @since 0.1
 */
public class SlidingWindow {

    /**
     * n : 时间窗口的大小
     */
    public static double[] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);
        int start = n - 1;
        return IntStream.range(start, sums.length).mapToDouble(i -> {
            double prefix = i == start ? 0 : sums[i - n];
            return (sums[i] - prefix) / n;
        }).toArray();
    }

    public static double[] simpleMovingAverage(double[] values) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);
//        int start = 5 - 1;
        return IntStream.range(4, sums.length).mapToDouble(i -> {
            double prefix = i == 4 ? 0 : sums[i - 5];
            return (sums[i] - prefix) / 5;
        }).toArray();
    }

    public static void main(String [] args){
        double[] values = new double[]{1d, 2d, 3d, 4d, 5, 6d, 7, 8, 9};
        double[] doubles = simpleMovingAverage(values, 5);
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);
        }

        IntStream.range(3, 7).forEach(System.out::println);
        IntStream.range(3, 7).mapToDouble(i -> {
//            double prefix = i == start ? 0 : sums[i - n];
//            return (sums[i] - prefix) / n;
            return i / 1;
        }).forEach(System.out::println);

    }
}

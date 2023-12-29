package com.mk.demos.sorting;

import java.util.Arrays;

/**
 * 希尔排序算法
 *
 * @author WangChen
 * Created on 2022/8/28
 * @since 1.0
 */
public class ShellSorting {

    public static void main(String[] args) {

    }

    public static void shell(int[] arr, int gap) {

        if (gap == 1) {
            Arrays.stream(arr).boxed().forEach(System.out::println);
            return;
        }

        int[] sorted = new int[arr.length];

        for (int i = 0; i < arr.length/gap; i=i+gap) {

//            Insertion.insertion();
            int tmp = arr[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if (tmp >= sorted[j]) {
                    sorted[j+1] = tmp;
                    break;
                }
                if (tmp < sorted[j]) {
                    sorted[j+1] = sorted[j];
                    sorted[j] = tmp;
                }
            }
        }

    }
}

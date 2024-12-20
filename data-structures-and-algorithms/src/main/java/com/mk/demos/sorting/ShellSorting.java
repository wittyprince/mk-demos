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
        int[] a1 = {5, 1, 3, 2, 4};
        int[] a2 = {5, 6, 1, 3, 2, 4};
        int[] a3 = {1, 2, 0, 3, 4, 5};
        int[] a4 = {1, 2, 1, 3, 4, 5};
        shellSort(a1);
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

    public static void shellSort(int[] a) {
        int i, j, gap;// gap为步长，每次减为原来的一半。
        for (gap = a.length / 2; gap >= 1; gap=gap/2) {
            for (i = gap; i <= a.length - 1; i = i + gap) {
                int tmp = a[i];
                for (j = i - gap; j >= 0; j = j -gap) {
                    if (a[j] > tmp) {
                        a[j + gap] = a[j];
                    } else {
                        break;
                    }
                }
                a[j + gap] = tmp;
            }
        }
        for (int k = 0; k <= a.length - 1; k++) {
            System.out.println(a[k]);
        }
    }
}

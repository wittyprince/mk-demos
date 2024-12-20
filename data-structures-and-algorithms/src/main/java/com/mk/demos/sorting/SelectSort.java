package com.mk.demos.sorting;

/**
 * SelectSort 选择排序
 *
 * @author WangChen
 * Created on 2024/12/20
 * @since 1.0
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a1 = {5, 1, 3, 2, 4};
        int[] a2 = {5, 6, 1, 3, 2, 4};
        int[] a3 = {1, 2, 0, 3, 4, 5};
        int[] a4 = {1, 2, 1, 3, 4, 5};
        int[] a5 = {1, 2, 3, 4, 5, 6};
        int[] a = selectSort(a2);
        for (int k = 0; k <= a.length - 1; k++) {
            System.out.println(a[k]);
        }
    }

    public static int[] selectSort(int[] a) {
        for (int i = 0; i< a.length - 1; i++) {
            int minIdx = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
            }
        }
        return a;
    }
}

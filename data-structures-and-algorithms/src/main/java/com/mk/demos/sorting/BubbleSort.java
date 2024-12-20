package com.mk.demos.sorting;

/**
 * BubbleSort 冒泡排序
 *
 * @author WangChen
 * Created on 2024/12/20
 * @since 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a1 = {5, 1, 3, 2, 4};
        int[] a2 = {5, 6, 1, 3, 2, 4};
        int[] a3 = {1, 2, 0, 3, 4, 5};
        int[] a4 = {1, 2, 1, 3, 4, 5};
        int[] a5 = {1, 2, 3, 4, 5, 6};
        bubbleSort(a5);
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (int k = 0; k <= a.length - 1; k++) {
            System.out.println(a[k]);
        }
    }

    private static void swap(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
    }
}

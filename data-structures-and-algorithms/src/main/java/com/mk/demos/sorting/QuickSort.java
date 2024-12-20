package com.mk.demos.sorting;

/**
 * QuickSort 快速排序
 *
 * @author WangChen
 * Created on 2024/12/20
 * @since 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a1 = {5, 1, 3, 2, 4};
        int[] a2 = {5, 6, 1, 3, 2, 4};
        int[] a3 = {1, 2, 0, 3, 4, 5};
        int[] a4 = {1, 2, 1, 3, 4, 5};
        int[] a5 = {1, 2, 3, 4, 5, 6};
        int[] a = quickSort(a1, 0, a1.length - 1);
        for (int k = 0; k <= a.length - 1; k++) {
            System.out.println(a[k]);
        }
    }

    public static int[] quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotPosition = partition(a, low, high);
            quickSort(a, low, pivotPosition - 1);
            quickSort(a, pivotPosition + 1, high);
        }
        return a;
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivot) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivot) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }
}

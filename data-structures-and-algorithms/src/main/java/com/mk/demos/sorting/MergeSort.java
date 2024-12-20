package com.mk.demos.sorting;

/**
 * MergeSort 归并排序
 *
 * @author WangChen
 * Created on 2024/12/20
 * @since 1.0
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a1 = {5, 1, 3, 2, 4};
        int[] a2 = {5, 6, 1, 3, 2, 4};
        int[] a3 = {1, 2, 0, 3, 4, 5};
        int[] a4 = {1, 2, 1, 3, 4, 5};
        int[] a5 = {1, 2, 3, 4, 5, 6};
        mergeSort(a1, 0, a1.length - 1);
        for (int k = 0; k <= a1.length - 1; k++) {
            System.out.println(a1[k]);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= high) {
            tmp[k++] = a[j++];
        }
        for (int l = 0; l < tmp.length; l++) {
            a[low + l] = tmp[l];
        }
    }

    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
}

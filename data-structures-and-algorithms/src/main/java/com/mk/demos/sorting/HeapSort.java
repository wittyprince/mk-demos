package com.mk.demos.sorting;

/**
 * HeapSort 堆排序
 *
 * @author WangChen
 * Created on 2024/12/20
 * @since 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a1 = {5, 1, 3, 2, 4};
        int[] a2 = {5, 6, 1, 3, 2, 4};
        int[] a3 = {1, 2, 0, 3, 4, 5};
        int[] a4 = {1, 2, 1, 3, 4, 5};
        int[] a5 = {1, 2, 3, 4, 5, 6};
        int[] a = heapSort2(a4);
        for (int k = 0; k <= a.length - 1; k++) {
            System.out.println(a[k]);
        }

    }

    // 堆排序
    public static int[] heapSort(int[] a) {
        buildHeap(a);
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            heapify(a, 0, i);
        }
        return a;
    }

    // 建堆 - 大顶堆
    public static void buildHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, i, a.length);
        }
    }

    // 堆化
    public static void heapify(int[] a, int idx, int length) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int largest = idx;
        if (left < length && a[left] > a[largest]) {
            largest = left;
        }
        if (right < length && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != idx) {
            swap(a, idx, largest);
            heapify(a, largest, length); //TODO ? 处理下沉
        }
    }

    // 交换
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    // ==================== 以下为不同的实现 ====================
    // 堆排序
    public static int[] heapSort2(int[] a) {
        buildMaxHeap(a, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            adjustMax(a, 0, i);
        }
        return a;
    }
    // 建堆-大顶堆
    public static void buildMaxHeap(int[] a, int length) {
        for (int i = length / 2; i >=0 ; i--) {
            adjustMax(a, i, length);
        }
    }

    // 堆化: 调整当前idx节点 及 可能产生的下沉
    public static void adjustMax(int[] a, int idx, int length) {
        int dad = idx;
        int son = 2 * dad + 1;
        while (son < length) {// 这里先判断左子树 < length, 并不代表右子树就不满足要求。
            if (son + 1 < length && a[son] < a[son + 1]) {
                son++;
            }
            if (a[dad] > a[son]) {
                break;
            }
            swap(a, dad, son);
            dad = son;
            son = 2 * dad + 1;
        }
    }
    
}

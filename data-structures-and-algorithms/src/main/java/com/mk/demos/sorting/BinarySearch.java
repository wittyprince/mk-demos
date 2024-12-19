package com.mk.demos.sorting;

import java.util.Arrays;

/**
 * 二分查找
 *
 * @author WangChen
 * Created on 2022/8/28
 * @since 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a3 = {0, 1, 2, 3, 4, 5, 6, 7};
        int target = 7;
        int i = binarySearch(a3, target);
        System.out.println(i);
    }

    public static void binary(int[] arr, int target) {
        Arrays.sort(arr);
        if (target < arr[0] || target > arr[arr.length - 1]) {
            System.out.println("not existing...");
            return;
        }
        int high = arr.length, low = 0, cursor;
        while (low < high) {
            cursor = (low + high) / 2;
            if (arr[cursor] > target) {
                high = cursor;
            }
            if (arr[cursor] < target) {
                low = cursor;
            }
            if (arr[cursor] == target) {
                System.out.println(cursor);
                break;
            }
        }


    }

    public static void recurse(int[] arr, int target) {
        int mid = arr.length/2;
//        if (mid < 0) {
//            System.out.println("null");
//            return;
//        }
        if (arr[mid] == target) {
            //TODO 这里输出的mid是有误的，因为每次递归后数组变了，其下标指针也就变了
            System.out.println(mid);
            return;
        }
        if (arr[mid] > target) {
            binary(Arrays.copyOf(arr, mid), target);
        }
        if (arr[mid] < target) {
            binary(Arrays.copyOfRange(arr, mid, arr.length), target);
        }
    }

    public static int binarySearch(int[] a, int x) {
        int low = 0, high = a.length -1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

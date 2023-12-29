package com.mk.demos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 插入排序
 *
 * 把一个无序数列分成两部分，一部分有序(初始时可以认为有序数列为空)，剩下的一部分无序，
 * 第一步：从剩下的无序数列中选择第一个数e与有序数列比较，
 * 比较方式：从后往前，如果e大于与其比较的数，则交换e与该参与比较的数的位置，直到e不大于与之比较的数为止
 * 第二步：重复第一步比较。
 *
 * @author WangChen
 * Created on 2022/8/28
 * @since 1.0
 */
public class Insertion {

    public static void main(String[] args) {

        int[] a1 = {5, 1, 3, 2, 4};
        int[] a2 = {5, 6, 1, 3, 2, 4};
        int[] a3 = {1, 2, 0, 3, 4, 5};
        int[] a4 = {1, 2, 1, 3, 4, 5};


        insertion2(a4);


    }

    public static void insertion(int[] arr) {
        // 注意：此时空间复杂度变为T(n)，不是T(1)
        int[] sorted = new int[arr.length];

        sorted[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
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
        // asList接受的参数是一个泛型的变长参数，而基本数据类型是无法泛型化的, 如下：
        // 这是因为把int类型的数组当参数了，所以转换后的列表就只包含一个int[]元素。
//        List<int[]> asList = Arrays.asList(sorted);
//        asList.forEach(System.out::println);

        /*
         * 基本类型数组先用流对每个元素装箱, 转化为对应包装类型数组
         * 再通过Arrays.asList转化为列表视图
         * 通过新建List的构造器, 新建列表List
         */
        Integer[] boxB = Arrays.stream(sorted).boxed().toArray(Integer[]::new);
        Arrays.asList(boxB).forEach(System.out::println);
//        List<Integer> list = new ArrayList<>(Arrays.asList(boxB));
    }

    public static void insertion2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp;
            int j;
            for (j = i; j > 0; j--) {
                if (arr[i+1] >= arr[i]) {
                    continue;
                }
                tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        }

    }
}

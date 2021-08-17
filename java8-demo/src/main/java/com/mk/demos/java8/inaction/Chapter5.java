package com.mk.demos.java8.inaction;

import com.mk.demos.commons.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个数字列表，返回所有的数对
 *
 * @author WangChen
 * Created on 2021/8/16 14:24
 * @since 0.1
 */
public class Chapter5 {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<List<Integer>> pairs1 = pairs1(list1, list2);
        System.out.println(pairs1);
        List<List<Integer>> collect = pairs1.stream().filter(integers -> integers.stream().mapToInt(i -> i).sum() % 3 == 0).collect(Collectors.toList());
        System.out.println(collect);

        List<int[]> pairs2 = pairs2(list1, list2);
        List<int[]> collect2 = pairs2.stream().filter(ints -> Arrays.stream(ints).sum() % 3 == 0).collect(Collectors.toList());
    }

    static List<List<Integer>> pairs1(List<Integer> list1, List<Integer> list2){
        List<List<Integer>> result = new ArrayList<>(list1.size() * list2.size());
        list1.forEach(i -> {
            list2.forEach(j -> {
                result.add(ListUtils.of(i, j));
            });
        });
        return result;
    }

    static List<int[]> pairs2(List<Integer> list1, List<Integer> list2){
        return list1.stream().flatMap(i -> {
            return list2.stream().map(j -> new int[]{i, j});
        }).collect(Collectors.toList());
    }
}

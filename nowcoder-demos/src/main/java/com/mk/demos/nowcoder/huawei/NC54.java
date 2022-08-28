package com.mk.demos.nowcoder.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * NC54 三数之和
 *
 * 描述
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 *
 * 数据范围：0 \le n \le 30000≤n≤3000，数组中各个元素值满足 |val | \le 100∣val∣≤100
 * 空间复杂度：O(n^2)O(n
 * 2
 *  )，时间复杂度 O(n^2)O(n
 * 2
 *  )
 *
 * 注意：
 * 三元组（a、b、c）中的元素可以按任意顺序排列。
 * 解集中不能包含重复的三元组。
 *
 * @author WangChen
 * Created on 2022/8/27
 * @since 1.0
 */
public class NC54 {


    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i=0; i<num.length; i++) {
            if (num[i] <= 0) {
                map1.put(num[i], i);
            } else {
                map2.put(num[i], i);
            }
        }

//        map1.forEach((k, v) -> {k});
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()){

        }

        return null;

    }
}

package com.mk.demos.nowcoder.huawei;

import java.util.HashMap;
import java.util.Map;

/**
 * NC61 两数之和
 *
 * 描述
 * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
 *
 * 数据范围：2\leq len(numbers) \leq 10^52≤len(numbers)≤10
 * 5
 *  ，-10 \leq numbers_i \leq 10^9−10≤numbers
 * i
 * ​
 *  ≤10
 * 9
 *  ，0 \leq target \leq 10^90≤target≤10
 * 9
 *
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
 *
 * @author WangChen
 * Created on 2022/8/27
 * @since 1.0
 */
public class NC61 {

    public static void main(String[] args) {

    }

    public int[] twoSum1 (int[] numbers, int target) {
        // write code here
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                if (target == (numbers[i] + numbers[j])) {
                    return new int[] {i+1, j+1};
                }
            }
        }
        return new int[2];
    }

    public int[] twoSum2 (int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]) + 1, i + 1};
            } else {
                // 先遍历，把元素放到map中，再取，再对比target，所以返回结果为
                // map.get(target - numbers[i]) + 1, i + 1
                map.put(numbers[i], i);
            }
        }
        return new int[2];
    }

    /**
     * [0,4,3,0],0 测试不通过
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum3(int[] numbers, int target) {
        int[] result = new int[2];

        // [0,4,3,0],0 测试不通过。target=0需特殊处理
        // [-3,4,3,90],0 测试不通过。target=0需特殊处理 //TODO
        if (target == 0) {
            int i=0;
            for (i=0; i<numbers.length; i++) {
                if (numbers[i] == 0) {
                    result[0] = i + 1;
                    break;
                }
            }
            for (int j=i+1; j<numbers.length; j++) {
                if (numbers[j] == 0) {
                    result[1] = j + 1;
                    break;
                }
            }
            return result;
        }


        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] <= target >> 1) {
                map1.put(numbers[i], i);
            } else {
                map2.put(numbers[i], i);
            }
        }

        map1.forEach((k, v) -> {
            if (map2.containsKey(target - k)) {
                if (v < map2.get(target - k)) {
                    result[0] = v + 1;
                    result[1] = map2.get(target - k) + 1;
                } else {
                    result[1] = v + 1;
                    result[0] = map2.get(target - k) + 1;
                }
            }
        });

        return result;
    }

}

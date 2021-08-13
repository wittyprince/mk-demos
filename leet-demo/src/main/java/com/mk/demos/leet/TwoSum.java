package com.mk.demos.leet;

import java.util.Arrays;

/**
 * <h3>两数之和</h3>
 *<br/>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WangChen
 * Created on 2021/8/4 20:48
 * @since 0.1
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int sum = 0;
        int a = 0, b = 0;
        for (int i=0; i< nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                sum = nums[i] + nums[j];
                if (target == sum){
                    a = i;
                    b = j;
                    break;
                }
            }
        }
        result[0] = a;
        result[1] = b;
        return result;
    }

    public static void main(String [] args){
        test1();
        test2();
        test3();
    }

    public static void test1(){
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] r = twoSum.twoSum(nums, target);
        Arrays.stream(r).forEach(System.out::println);
        System.out.println("----------------");
    }

    public static void test2(){
        int[] nums = {3, 2, 4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] r = twoSum.twoSum(nums, target);
        Arrays.stream(r).forEach(System.out::println);
        System.out.println("----------------");
    }

    public static void test3(){
        int[] nums = {3, 3};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] r = twoSum.twoSum(nums, target);
        Arrays.stream(r).forEach(System.out::println);
        System.out.println("----------------");
    }



}

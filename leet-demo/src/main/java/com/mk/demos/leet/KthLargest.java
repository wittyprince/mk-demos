package com.mk.demos.leet;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * KthLargest
 *
 * kth-largest-element-in-a-stream 数据流中的第K大元素
 *
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例:
 *      int k = 3;
 *      int[] arr = [4,5,8,2];
 *      KthLargest kthLargest = new KthLargest(3, arr);
 *      kthLargest.add(3);   // returns 4
 *      kthLargest.add(5);   // returns 5
 *      kthLargest.add(10);  // returns 5
 *      kthLargest.add(9);   // returns 8
 *      kthLargest.add(4);   // returns 8
 * 说明:
 *      你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 *
 *
 * @author WangChen
 * Created on 2019/11/27 10:24
 * @since 1.0
 */
public class KthLargest {

    private int capacity;
    private Queue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        queue = new PriorityQueue<>();
        for (Integer i : nums){
            queue.add(i);
        }
        while (queue.size() > k){
            queue.remove();
        }
    }

    public int add(int val) {
        if (queue.isEmpty()){
            queue.add(val);
            return val;
        }
        Integer min = queue.element();
        if (queue.size() >= capacity){
            if (val > min){
                queue.add(val);
                queue.remove();
            }
        } else {
            queue.add(val);
        }
        return queue.element();
    }
    /**
     * Comparator to sort
     */
    public static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer e1, Integer e2) {
            return e1 - e2;
        }
    };

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    public static void main(String[] args){
        test2();
    }

    private static void test1(){
        int k = 1;
        int[] nums = new int[]{};
        KthLargest kthLargest = new KthLargest(k, nums);
        int a1 = kthLargest.add(-3);// returns 4
        System.out.println(a1);
        int a2 = kthLargest.add(-2);// returns 5
        System.out.println(a2);
        int a3 = kthLargest.add(-4);// returns 5
        System.out.println(a3);
        int a4 = kthLargest.add(0);// returns 8
        System.out.println(a4);
        int a5 = kthLargest.add(4);// returns 8
        System.out.println(a5);
    }

    public static void test2(){
        int k = 2;
        int[] nums = new int[]{0};
        KthLargest kthLargest = new KthLargest(k, nums);
        int a1 = kthLargest.add(-1);// returns 4
        System.out.println(a1);
        int a2 = kthLargest.add(1);// returns 5
        System.out.println(a2);
        int a3 = kthLargest.add(-2);// returns 5
        System.out.println(a3);
        int a4 = kthLargest.add(-4);// returns 8
        System.out.println(a4);
        int a5 = kthLargest.add(3);// returns 8
        System.out.println(a5);
    }
}

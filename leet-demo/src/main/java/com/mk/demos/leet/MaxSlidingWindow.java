package com.mk.demos.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * maxSlidingWindow
 * sliding-window-maximum 滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 示例:
 *      输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 *      输出: [3,3,5,5,6,7]
 *      解释:
 *
 *        滑动窗口的位置                最大值
 *      ---------------               -----
 *      [1  3  -1] -3  5  3  6  7       3
 *       1 [3  -1  -3] 5  3  6  7       3
 *       1  3 [-1  -3  5] 3  6  7       5
 *       1  3  -1 [-3  5  3] 6  7       5
 *       1  3  -1  -3 [5  3  6] 7       6
 *       1  3  -1  -3  5 [3  6  7]      7
 *
 * 提示：
 *      你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 进阶：
 *      你能在线性时间复杂度内解决此题吗？
 *
 * @author WangChen
 * Created on 2019/11/27 16:12
 * @since 1.0
 */
public class MaxSlidingWindow {

    /**
     * 	超出时间限制
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null){
            return null;
        } else if (nums.length == 0){
            return new int[]{};
        } else if (nums.length <= k){
            IntStream intStream = Arrays.stream(nums).map(i -> i * (-1)).sorted().map(i -> i * (-1));
            return new int[]{intStream.max().orElse(nums[0])};
        } else {
            int[] resultArr = new int[nums.length - k + 1];
            for (int i = 0; i <= nums.length - k; i++){
                Integer[] arr = new Integer[k];
                for (int j = i; j < k + i && j < nums.length; j++){
                    arr[j - i] = nums[j];
                }
                Arrays.sort(arr, Collections.reverseOrder());
                resultArr[i] = arr[0];
            }
            return resultArr;
        }
    }

    /**
     * passed leet通过
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null){
            return null;
        } else if (nums.length == 0){
          return nums;
        } else if (nums.length <= k){
            return new int[]{Arrays.stream(nums).max().orElse(nums[0])};
        } else {
//            queue = new PriorityQueue<>(comparatorDesc);
//            for (Integer i : nums){
//                while (queue.size() < k){
//                    queue.add(i);
//                }// 循环过后queue.size == k
//                Integer max = queue.element();
//
//            }
            int[] resultArr = new int[nums.length - k + 1];
            int max;
            for (int i = 0; i <= nums.length - k; i++){
                max = nums[i];
                for (int j = i; j < k + i && j < nums.length; j++){
                    if (max < nums[j]){
                        max = nums[j];
                    }
                }
                resultArr[i] = max;
            }
            return resultArr;
        }
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null){
            return null;
        } else if (nums.length == 0){
            return nums;
        } else if (nums.length <= k){
            return new int[]{Arrays.stream(nums).max().orElse(nums[0])};
        } else {
            List<Integer> resultArr = new ArrayList<>(nums.length - k + 1);
            Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);// PriorityQueue 默认是minHeap, 可以使用一个比较器转换为maxHeap
            int i = 0;
            for (; i < k; i++){
                queue.add(nums[i]);
            }
            resultArr.add(queue.element());
            for (i = k; i < nums.length; i++){
                queue.remove(nums[i - k]);
                queue.add(nums[i]);
                resultArr.add(queue.element());
            }
            return resultArr.stream().mapToInt(a->a).toArray();
        }
    }

    public int[] maxSlidingWindow4(int[] nums, int k) {
        if (nums == null) {
            return null;
        } else if (nums.length == 0) {
            return nums;
        } else if (nums.length <= k) {
            return new int[]{Arrays.stream(nums).max().orElse(nums[0])};
        } else {
            List<Integer> resultArr = new ArrayList<>(nums.length - k + 1);
            Deque<Integer> queue = new LinkedList<>();
            int i = 0;
            for (; i < k; i++){
                int j = i - 1;
                while (j >= 0 && nums[i] > nums[j]){// 对每次新加入的元素nums[i]进行比较，如果大于前面的，就把前面的元素移除
                    queue.remove(j);
                    j--;
                }
                queue.add(i);
            }
            resultArr.add(nums[queue.element()]);
            for (i = k; i < nums.length; i++){
                queue.remove(i - k);
                int j = i - 1;
                while (j > i - k && nums[i] > nums[j]){
                    queue.remove(j);
                    j--;
                }
                queue.add(i);
                resultArr.add(nums[queue.element()]);
            }
            return resultArr.stream().mapToInt(a->a).toArray();
        }

    }

    public int[] maxSlidingWindow5(int[] nums, int k) {
        if (nums == null) {
            return null;
        } else if (nums.length == 0) {
            return nums;
        } else if (nums.length <= k) {
            return new int[]{Arrays.stream(nums).max().orElse(nums[0])};
        } else {
            List<Integer> resultArr = new ArrayList<>(nums.length - k + 1);
            Deque<Integer> queue = new LinkedList<>();
            int i = 0;
            for (; i < k; i++){
                while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]){
                    queue.removeLast();
                }
                queue.addLast(i);
            }
            resultArr.add(nums[queue.peekFirst()]);
            for (i = k; i < nums.length; i++){
                while (!queue.isEmpty() && queue.peekFirst() <= i - k){
                    queue.removeFirst();
                }
                while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]){
                    queue.removeLast();
                }
                queue.addLast(i);
                resultArr.add(nums[queue.peekFirst()]);
            }
            return resultArr.stream().mapToInt(a->a).toArray();
        }
    }

    public static Comparator<Integer> comparatorDesc = new Comparator<Integer>() {
        @Override
        public int compare(Integer e1, Integer e2) {
            return e2 - e1;
        }
    };

    public static void main(String[] args){
        test4();
    }

    private static void test1(){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = new MaxSlidingWindow().maxSlidingWindow5(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    private static void test2(){
        int[] nums = new int[]{9, 11};
        int k = 2;
        int[] ints = new MaxSlidingWindow().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    private static void test3(){
        int[] nums = new int[]{};
        int k = 0;
        int[] ints = new MaxSlidingWindow().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    private static void test4(){
        int[] nums = {1, -1};
        int k = 1;
        int[] ints = new MaxSlidingWindow().maxSlidingWindow5(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}

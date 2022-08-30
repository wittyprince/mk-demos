package com.mk.demos.nowcoder.huawei;

/**
 * 递归：NC68.跳台阶
 *
 * 描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 数据范围：1 \leq n \leq 401≤n≤40
 * 要求：时间复杂度：O(n)O(n) ，空间复杂度： O(1)O(1)
 *
 * @author WangChen
 * Created on 2022/8/29
 * @since 1.0
 */
public class NC68 {

    public static void main(String[] args) {

    }

    public int jumpFloor(int target) {

        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return jumpFloor(target-1) + jumpFloor(target - 2);
        }
    }

}

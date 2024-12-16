package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，请你找出一个下标从 0 开始的整数数组 answer ，其中：
 * <p>
 * answer.length == nums.length
 * answer[i] = |leftSum[i] - rightSum[i]|
 * 其中：
 * <p>
 * leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
 * rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
 * 返回数组 answer 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,4,8,3]
 * 输出：[15,1,11,22]
 * 解释：数组 leftSum 为 [0,10,14,22] 且数组 rightSum 为 [15,11,3,0] 。
 * 数组 answer 为 [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[0]
 * 解释：数组 leftSum 为 [0] 且数组 rightSum 为 [0] 。
 * 数组 answer 为 [|0 - 0|] = [0] 。
 */
public class Solution2574 {
    public static void main(String[] args) {
//        int[] nums = new int[]{10, 4, 8, 3};
        int[] nums = new int[]{1};
        int[] ints = new Solution2574().leftRightDifference(nums);
        System.out.println("ints = " + Arrays.toString(ints));
    }


    public int[] leftRightDifference(int[] nums) {
        int[] rs = new int[nums.length];

        int leftSum = 0;
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            rightSum -= num;
            rs[i] = Math.abs(leftSum - rightSum);
            leftSum += num;
        }
        return rs;
    }
}

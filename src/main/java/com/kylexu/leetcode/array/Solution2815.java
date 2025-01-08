package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。请你从 nums 中找出和 最大 的一对数，且这两个数数位上最大的数字相等。
 * 返回最大和，如果不存在满足题意的数字对，返回 -1 。
 * 示例 1：
 * 输入：nums = [51,71,17,24,42]
 * 输出：88
 * 解释：
 * i = 1 和 j = 2 ，nums[i] 和 nums[j] 数位上最大的数字相等，且这一对的总和 71 + 17 = 88 。
 * i = 3 和 j = 4 ，nums[i] 和 nums[j] 数位上最大的数字相等，且这一对的总和 24 + 42 = 66 。
 * 可以证明不存在其他数对满足数位上最大的数字相等，所以答案是 88 。
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：不存在数对满足数位上最大的数字相等。
 */
public class Solution2815 {
    public static void main(String[] args) {
        int[] nums = new int[]{84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
        System.out.println(new Solution2815().maxSum(nums));
    }

    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int max = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (getMaxV(nums[i]) == getMaxV(nums[j])) {
                    max = Math.max(nums[i] + nums[j], max);
                }
            }
        }

        return max;
    }


    public int getMaxV(int a) {
        int temp = -1;

        while (a != 0) {
            temp = Math.max(a % 10, temp);
            a = a / 10;
        }

        return temp;
    }
}

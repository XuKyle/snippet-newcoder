package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution3202 {
    public static void main(String[] args) {
//        nums = [1,2,3,4,5], k = 2
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        int i = new Solution3202().maximumLength(nums, k);
        System.out.println("i = " + i);
    }

    public int maximumLength(int[] nums, int k) {
// 获取数组长度
        int length = nums.length;

        // dp[i][j]: 以索引i元素结尾，且相邻元素和模k等于j的最长子序列长度
        int[][] dp = new int[length][k];

        // 初始化DP数组，每个元素初始值为1（仅包含当前元素的子序列）
        for (int[] item : dp) {
            Arrays.fill(item, 1);
        }

        // 记录全局最大长度
        int result = 0;

        // 遍历每个元素作为子序列的结尾
        for (int i = 0; i < length; i++) {
            // 遍历所有可能的前驱元素
            for (int j = 0; j < i; j++) {
                // 计算当前元素与前驱元素的和模k的结果
                int mod = (nums[i] + nums[j]) % k;

                // 状态转移：若加入当前元素可形成更长的子序列，则更新长度
                dp[i][mod] = dp[j][mod] + 1;

                // 更新全局最大长度
                result = Math.max(dp[i][mod], result);
            }
        }

        // 返回全局最大长度
        return result;
    }
}

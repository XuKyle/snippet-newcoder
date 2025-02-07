package com.kylexu.leetcode.array;

/**
 * 给你一个长度为 n 的整数数组 nums 。
 * <p>
 * 分区 是指将数组按照下标 i （0 <= i < n - 1）划分成两个 非空 子数组，其中：
 * <p>
 * 左子数组包含区间 [0, i] 内的所有下标。
 * 右子数组包含区间 [i + 1, n - 1] 内的所有下标。
 * 对左子数组和右子数组先求元素 和 再做 差 ，统计并返回差值为 偶数 的 分区 方案数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,10,3,7,6]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 共有 4 个满足题意的分区方案：
 * <p>
 * [10]、[10, 3, 7, 6] 元素和的差值为 10 - 26 = -16 ，是偶数。
 * [10, 10]、[3, 7, 6] 元素和的差值为 20 - 16 = 4，是偶数。
 * [10, 10, 3]、[7, 6] 元素和的差值为 23 - 13 = 10，是偶数。
 * [10, 10, 3, 7]、[6] 元素和的差值为 30 - 6 = 24，是偶数。
 */
public class Solution3432 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(new Solution3432().countPartitions(nums));
    }

    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int rs = 0;

        int left = 0;
        int right;

        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            left += num;
            right = sum - left;

            if ((left - right) % 2 == 0) {
                rs++;
            }
        }

        return rs;
    }
}

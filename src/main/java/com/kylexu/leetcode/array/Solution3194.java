package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 你有一个初始为空的浮点数数组 averages。另给你一个包含 n 个整数的数组 nums，其中 n 为偶数。
 * 你需要重复以下步骤 n / 2 次：
 * <p>
 * 从 nums 中移除 最小 的元素 minElement 和 最大 的元素 maxElement。
 * 将 (minElement + maxElement) / 2 加入到 averages 中。
 * 返回 averages 中的 最小 元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [7,8,3,4,15,13,4,1]
 * <p>
 * 输出： 5.5
 * <p>
 * 解释：
 * <p>
 * 步骤	nums	averages
 * 0	[7,8,3,4,15,13,4,1]	[]
 * 1	[7,8,3,4,13,4]	[8]
 * 2	[7,8,4,4]	[8,8]
 * 3	[7,4]	[8,8,6]
 * 4	[]	[8,8,6,5.5]
 * 返回 averages 中最小的元素，即 5.5。
 * 示例 2：
 * <p>
 * 输入： nums = [1,9,8,3,10,5]
 * <p>
 * 输出： 5.5
 * <p>
 * 解释：
 * <p>
 * 步骤	nums	averages
 * 0	[1,9,8,3,10,5]	[]
 * 1	[9,8,3,5]	[5.5]
 * 2	[8,5]	[5.5,6]
 * 3	[]	[5.5,6,6.5]
 * 示例 3：
 * <p>
 * 输入： nums = [1,2,3,7,8,9]
 * <p>
 * 输出： 5.0
 * <p>
 * 解释：
 * <p>
 * 步骤	nums	averages
 * 0	[1,2,3,7,8,9]	[]
 * 1	[2,3,7,8]	[5]
 * 2	[3,7]	[5,5]
 * 3	[]	[5,5,5]
 */
public class Solution3194 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 8, 3, 4, 15, 13, 4, 1};
        System.out.println(new Solution3194().minimumAverage(nums));
    }

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] rs = new int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            rs[i] = nums[i] + nums[n - i - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int r : rs) {
            min = Math.min(r, min);
        }
        return min / 2.0;
    }
}

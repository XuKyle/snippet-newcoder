package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [10,1,2,7,1,3], p = 2
 * 输出：1
 * 解释：第一个下标对选择 1 和 4 ，第二个下标对选择 2 和 5 。
 * 最大差值为 max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1 。所以我们返回 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,2,1,2], p = 1
 * 输出：0
 * 解释：选择下标 1 和 3 构成下标对。差值为 |2 - 2| = 0 ，这是最大差值的最小值。
 */
public class Solution2616 {
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 1, 3};
        int p = 2;
        int i = new Solution2616().minimizeMax(nums, p);
        System.out.println("i = " + i);
    }

    public int minimizeMax(int[] nums, int p) {
        int rs = Integer.MIN_VALUE;

        for (int i = 0; i < p; i++) {
            Arrays.sort(nums);

            int minGap = Integer.MAX_VALUE;
            int currentGap = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length - 1; j++) {
                currentGap = nums[j + 1] - nums[j];
                minGap = Math.min(currentGap, minGap);
                nums = Arrays.copyOfRange(nums, 2, nums.length);
            }
            rs = Math.max(rs, minGap);
        }

        // todo
        return rs;
    }
}

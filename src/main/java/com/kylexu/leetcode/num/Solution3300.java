package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * 输入：nums = [10,12,13,14]
 * 输出：1
 * 解释：
 * nums 替换后变为 [1, 3, 4, 5] ，最小元素为 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 替换后变为 [1, 2, 3, 4] ，最小元素为 1 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [999,19,199]
 * <p>
 * 输出：10
 * <p>
 * 解释：
 * <p>
 * nums 替换后变为 [27, 10, 19] ，最小元素为 10 。
 */
public class Solution3300 {
    public static void main(String[] args) {
        int[] nums = new int[]{999, 19, 199};
        System.out.println(new Solution3300().minElement(nums));
    }

    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(adjust(num), min);
        }

        return min;
    }

    public int adjust(int num) {
        int rs = 0;
        while (num != 0) {
            rs += num % 10;
            num = num / 10;
        }
        return rs;
    }
}

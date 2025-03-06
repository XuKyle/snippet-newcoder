package com.kylexu.leetcode.array;

/**
 * 输入：nums = [1,3,5,2,4,8,2,2]
 * 输出：1
 * 解释：重复执行算法会得到下述数组。
 * 第一轮：nums = [1,5,4,2]
 * 第二轮：nums = [1,4]
 * 第三轮：nums = [1]
 * 1 是最后剩下的那个数字，返回 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [3]
 * 输出：3
 * 解释：3 就是最后剩下的数字，返回 3 。
 */
public class Solution2293 {
    public static void main(String[] args) {
        int[] nums = new int[]{3};
        System.out.println(new Solution2293().minMaxGame(nums));
    }

    public int minMaxGame(int[] nums) {
        int n = nums.length;

        while (n != 1) {
            n = n / 2;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
        }

        return nums[0];
    }
}

package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 通过以下 3 个操作，数组中的所有元素都可以被 3 整除：
 * <p>
 * 将 1 减少 1 。
 * 将 2 增加 1 。
 * 将 4 减少 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,6,9]
 * <p>
 * 输出：0
 */
public class Solution3190 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 9};
        int i = new Solution3190().minimumOperations(nums);
        System.out.println("i = " + i);
    }

    public int minimumOperations(int[] nums) {
        int rs = 0;

        for (int num : nums) {
            if (num % 3 != 0) {
                rs++;
            }
        }

        return rs;
    }
}

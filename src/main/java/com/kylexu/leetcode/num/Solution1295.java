package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数）
 * 345 是 3 位数字（位数为奇数）
 * 2 是 1 位数字（位数为奇数）
 * 6 是 1 位数字 位数为奇数）
 * 7896 是 4 位数字（位数为偶数）
 * 因此只有 12 和 7896 是位数为偶数的数字
 * 示例 2：
 * <p>
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 */
public class Solution1295 {
    public static void main(String[] args) {
        int[] nums = new int[]{12, 345, 2, 6, 7896};
        System.out.println(new Solution1295().findNumbers(nums));
    }

    public int findNumbers(int[] nums) {
        int rs = 0;

        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                rs++;
            }
        }

        return rs;
    }
}

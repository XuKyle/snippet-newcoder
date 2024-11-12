package com.kylexu.leetcode.bitwise;

/**
 * 示例 1 ：
 * <p>
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 * <p>
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 */
public class Solution136 {
    public static void main(String[] args) {
        int[] ints = {2, 2, 1};
        int singleNumber = new Solution136().singleNumber(ints);
        System.out.println("singleNumber = " + singleNumber);
    }

    public int singleNumber(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r = r ^ num;
        }
        return r;
    }
}

package com.kylexu.leetcode.other;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,6,9,10]
 * 输出：2
 * 解释：
 * nums 中最小的数是 2
 * nums 中最大的数是 10
 * 2 和 10 的最大公约数是 2
 */
public class Solution1979 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6, 9, 10};
        System.out.println(new Solution1979().findGCD(nums));
    }

    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        return gcd(max, min);
    }

    private int gcd(int max, int min) {
        int larger = Math.max(max, min);
        int smaller = Math.min(max, min);
        return larger % smaller == 0 ? smaller : gcd(smaller, larger % smaller);
    }
}

package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 * <p>
 * 输入：n = 3
 * 输出：false
 */
public class Solution231 {
    public static void main(String[] args) {
        System.out.println(new Solution231().isPowerOfTwo(4));
        System.out.println(new Solution231().isPowerOfTwo(2147483647));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

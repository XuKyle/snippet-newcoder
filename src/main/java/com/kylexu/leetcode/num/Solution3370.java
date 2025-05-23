package com.kylexu.leetcode.num;

import java.util.Arrays;

/**
 * 给你一个正整数 n。
 * <p>
 * 返回 大于等于 n 且二进制表示仅包含 置位 位的 最小 整数 x 。
 * <p>
 * 置位 位指的是二进制表示中值为 1 的位。
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 5
 * <p>
 * 输出： 7
 * <p>
 * 解释：
 * <p>
 * 7 的二进制表示是 "111"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 10
 * <p>
 * 输出： 15
 * <p>
 * 解释：
 * <p>
 * 15 的二进制表示是 "1111"。
 * <p>
 * 示例 3：
 * <p>
 * 输入： n = 3
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 3 的二进制表示是 "11"。
 */
public class Solution3370 {
    public static void main(String[] args) {
        int n = 10;
        int rs = new Solution3370().smallestNumber(n);
        System.out.println("rs = " + rs);
    }

    public int smallestNumber(int n) {
        char[] charArray = Integer.toBinaryString(n).toCharArray();
        Arrays.fill(charArray, '1');
        return Integer.parseInt(new String(charArray), 2);
    }
}

package com.kylexu.leetcode.binary;

/**
 * 示例 1：
 * <p>
 * 输入：start = 10, goal = 7
 * 输出：3
 * 解释：10 和 7 的二进制表示分别为 1010 和 0111 。我们可以通过 3 步将 10 转变成 7 ：
 * - 翻转右边起第一位得到：1010 -> 1011 。
 * - 翻转右边起第三位：1011 -> 1111 。
 * - 翻转右边起第四位：1111 -> 0111 。
 * 我们无法在 3 步内将 10 转变成 7 。所以我们返回 3 。
 * 示例 2：
 * <p>
 * 输入：start = 3, goal = 4
 * 输出：3
 * 解释：3 和 4 的二进制表示分别为 011 和 100 。我们可以通过 3 步将 3 转变成 4 ：
 * - 翻转右边起第一位：011 -> 010 。
 * - 翻转右边起第二位：010 -> 000 。
 * - 翻转右边起第三位：000 -> 100 。
 * 我们无法在 3 步内将 3 变成 4 。所以我们返回 3 。
 */
public class Solution2220 {
    public static void main(String[] args) {
        int start = 10;
        int goal = 7;
        System.out.println(new Solution2220().minBitFlips(start, goal));
    }

    public int minBitFlips(int start, int goal) {
        int rs = 0;

        String startBinaryString = new StringBuilder(Integer.toBinaryString(start)).reverse().toString();
        String goalBinaryString = new StringBuilder(Integer.toBinaryString(goal)).reverse().toString();

        int n = Math.max(startBinaryString.length(), goalBinaryString.length());
        int startN = startBinaryString.length();
        int goalN = goalBinaryString.length();

        for (int i = 0; i < n; i++) {
            if (i < startN && i < goalN) {
                if (startBinaryString.charAt(i) != goalBinaryString.charAt(i)) {
                    rs++;
                }
            } else if (i >= startN) {
                if (goalBinaryString.charAt(i) != '0') {
                    rs++;
                }
            } else {
                if (startBinaryString.charAt(i) != '0') {
                    rs++;
                }
            }
        }

        return rs;
    }
}

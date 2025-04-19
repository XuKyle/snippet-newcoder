package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * 输入：blocks = "WBBWWBBWBW", k = 7
 * 输出：3
 * 解释：
 * 一种得到 7 个连续黑色块的方法是把第 0 ，3 和 4 个块涂成黑色。
 * 得到 blocks = "BBBBBBBWBW" 。
 * 可以证明无法用少于 3 次操作得到 7 个连续的黑块。
 * 所以我们返回 3 。
 * 示例 2：
 * <p>
 * 输入：blocks = "WBWBBBW", k = 2
 * 输出：0
 * 解释：
 * 不需要任何操作，因为已经有 2 个连续的黑块。
 * 所以我们返回 0 。
 */
public class Solution2379 {
    public static void main(String[] args) {
        String blocks = "BWWWBB";
        int k = 6;
        int rs = new Solution2379().minimumRecolors(blocks, k);
        System.out.println("rs = " + rs);
    }

    public int minimumRecolors(String blocks, int k) {
        if (blocks.length() < k) {
            return -1;
        }

        int rs = Integer.MAX_VALUE;
        int n = blocks.length();

        for (int i = 0; i < n - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < (i + k); j++) {
                if (blocks.charAt(j) == 'W') {
                    sum++;
                }
            }
            rs = Math.min(sum, rs);
        }

        return rs;
    }
}

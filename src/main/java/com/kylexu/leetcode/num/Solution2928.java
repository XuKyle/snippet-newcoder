package com.kylexu.leetcode.num;

/**
 * 示例 1：
 * <p>
 * 输入：n = 5, limit = 2
 * 输出：3
 * 解释：总共有 3 种方法分配 5 颗糖果，且每位小朋友的糖果数不超过 2 ：(1, 2, 2) ，(2, 1, 2) 和 (2, 2, 1) 。
 * 示例 2：
 * <p>
 * 输入：n = 3, limit = 3
 * 输出：10
 * 解释：总共有 10 种方法分配 3 颗糖果，且每位小朋友的糖果数不超过 3 ：(0, 0, 3) ，(0, 1, 2) ，(0, 2, 1) ，(0, 3, 0) ，(1, 0, 2) ，(1, 1, 1) ，(1, 2, 0) ，(2, 0, 1) ，(2, 1, 0) 和 (3, 0, 0) 。
 */
public class Solution2928 {
    public static void main(String[] args) {
        int n = 5, limit = 2;
        int rs = new Solution2928().distributeCandies(n, limit);
        System.out.println("rs = " + rs);
    }

    public int distributeCandies(int n, int limit) {
        int rs = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                for (int k = 0; k <= limit; k++) {
                    if (i + j + k == n) {
                        rs++;
                    }
                }
            }
        }
        return rs;
    }
}

package com.kylexu.leetcode.bitwise;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class Solution461 {
    public static void main(String[] args) {
        System.out.println(new Solution461().hammingDistance(1, 4));
    }


    public int hammingDistance(int x, int y) {
        int rs = 0;
        for (int xor = x ^ y; xor != 0; xor &= (xor - 1)) {
            rs++;
        }
        return rs;
    }
}

package com.kylexu.leetcode.other;

import java.util.Arrays;

/**
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * 示例 1：
 * <p>
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * 示例 2：
 * <p>
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 */
public class Solution1720 {
    public static void main(String[] args) {
        int[] encoded = new int[]{6, 2, 7, 3};
        int[] decoded = new Solution1720().decode(encoded, 4);
        System.out.println("decoded = " + Arrays.toString(decoded));
    }

    public int[] decode(int[] encoded, int first) {
        int[] rs = new int[encoded.length + 1];

        rs[0] = first;
        for (int i = 1; i < rs.length; i++) {
            rs[i] = encoded[i - 1] ^ rs[i - 1];
        }

        return rs;
    }
}

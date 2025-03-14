package com.kylexu.leetcode.num;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
 * 转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。
 * 示例 1：
 * <p>
 * 输入：n = 34, k = 6
 * 输出：9
 * 解释：34 (10 进制) 在 6 进制下表示为 54 。5 + 4 = 9 。
 * 示例 2：
 * <p>
 * 输入：n = 10, k = 10
 * 输出：1
 * 解释：n 本身就是 10 进制。 1 + 0 = 1 。
 */
public class Solution1837 {
    public static void main(String[] args) {
        int n = 10;
        int k = 10;
        System.out.println(new Solution1837().sumBase(n, k));
    }

    public int sumBase(int n, int k) {
        List<Integer> t = new ArrayList<>();

        while (n != 0) {
            t.add(n % k);
            n = n / k;
        }

        return t.stream().mapToInt(Integer::intValue).sum();
    }
}

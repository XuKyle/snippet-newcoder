package com.kylexu.leetcode.num;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1925 {
    public static void main(String[] args) {
        int n = 5;
        int i = new Solution1925().countTriples(n);
        System.out.println("i = " + i);
    }

    /**
     * 一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。
     * <p>
     * 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。
     * 示例 1：
     * <p>
     * 输入：n = 5
     * 输出：2
     * 解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
     *
     * @param n
     * @return
     */
    public int countTriples(int n) {
        int rs = 0;

        Set<String> container = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i * i + j * j == k * k) {
                        String an = i + "," + j + "," + k;
                        if (!container.contains(an)) {
                            rs++;
                        }
                        container.add(an);
                    }
                }
            }

        }

        return rs;
    }
}

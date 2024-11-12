package com.kylexu.leetcode.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Solution70 {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int rs = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, rs);
            return rs;
        }
    }

    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int last2 = 1;
        int last1 = 2;
        int now = 0;
        for (int i = 3; i <= n; i++) {
            now = last1 + last2;
            last2 = last1;
            last1 = now;
        }

        return now;
    }

    public static void main(String[] args) {
        int climbed = new Solution70().climbStairs(10);
        int climbed1 = new Solution70().climbStairs1(10);

        System.out.println(climbed);
        System.out.println("climbed1 = " + climbed1);
    }
}

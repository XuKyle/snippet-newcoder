package com.kylexu.leetcode.num;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，到 highLimit 结束
 * （包括 lowLimit 和 highLimit ，即 n == highLimit - lowLimit + 1）。
 * 另有无限数量的盒子，编号从 1 到 infinity 。
 * <p>
 * 你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。
 * <p>
 * 给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球数量。
 */
public class Solution1742 {
    public static void main(String[] args) {
        int lowLimit = 1;
        int highLimit = 10;
        System.out.println(new Solution1742().countBalls(lowLimit, highLimit));
    }

    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        Map<Integer, List<Integer>> bucket = new HashMap<>();

        for (int i = lowLimit; i <= highLimit; i++) {
            bucket.computeIfAbsent(sum(i), k -> new ArrayList<>()).add(i);
            max = Math.max(bucket.get(sum(i)).size(), max);
        }

        return max;
    }

    private int sum(int i) {
        if (i < 10) {
            return i;
        }

        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}

package com.kylexu.leetcode.array;

/**
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 * <p>
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 * <p>
 * 返回 人口最多 且 最早 的年份。
 * <p>
 * 示例 1：
 * <p>
 * 输入：logs = [[1993,1999],[2000,2010]]
 * 输出：1993
 * 解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
 * 示例 2：
 * <p>
 * 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
 * 输出：1960
 * 解释：
 * 人口最多为 2 ，分别出现在 1960 和 1970 。
 * 其中最早年份是 1960 。
 * <p>
 * 1 <= logs.length <= 100
 * 1950 <= birthi < deathi <= 2050
 */
public class Solution1854 {
    public static void main(String[] args) {
        int[][] logs = new int[][]{{1993, 1999}, {2000, 2010}};
        System.out.println(new Solution1854().maximumPopulation(logs));
    }

    public int maximumPopulation(int[][] logs) {
        int[] memo = new int[102];

        for (int[] log : logs) {
            int start = log[0];
            int end = log[1];

            while (start < end) {
                memo[start - 1950] += 1;
                start++;
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] > max) {
                max = memo[i];
                index = i;
            }
        }

        return index + 1950;
    }
}

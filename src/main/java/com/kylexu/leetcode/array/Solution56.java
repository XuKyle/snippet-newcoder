package com.kylexu.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution56 {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] intervals = {{1, 4}, {0, 4}};
        int[][] merge = new Solution56().merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int n = intervals.length;
        int i = 0;

        List<int[]> rs = new ArrayList<>();
        while (i < n) {
            int[] interval = intervals[i];

            int start = interval[0];
            int end = interval[1];

            int j = i + 1;

            while (j < n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            rs.add(new int[]{start, end});
            i = j;
        }

        return rs.toArray(new int[rs.size()][]);
    }
}

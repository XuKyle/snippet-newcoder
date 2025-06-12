package com.kylexu.leetcode.array;

import java.util.*;

/**
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Solution57 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] rs = new Solution57().insert(intervals, newInterval);
        System.out.println("rs = " + Arrays.deepToString(rs));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];

        List<Pair> rs = new ArrayList<>();
        for (int[] interval : intervals) {
            rs.add(new Pair(interval[0], interval[1]));
        }
        rs.add(new Pair(newInterval[0], newInterval[1]));

        rs.sort(Comparator.comparingInt(Pair::getStart));

        LinkedList<Pair> holder = new LinkedList<>();

        for (Pair current : rs) {
            if (holder.isEmpty()) {
                holder.add(current);
            } else {
                Pair last = holder.peekLast();
                if (current.start <= last.end) {
                    last.end = Math.max(last.end, current.end);
                } else {
                    holder.add(current);
                }
            }
        }

        int[][] rs1 = new int[holder.size()][2];
        for (int i = 0; i < holder.size(); i++) {
            rs1[i][0] = holder.get(i).start;
            rs1[i][1] = holder.get(i).end;
        }

        return rs1;
    }

    private static class Pair {
        public int start;
        public int end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}

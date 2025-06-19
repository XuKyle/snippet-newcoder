package com.kylexu.leetcode.matrix;

import java.util.Arrays;

public class Solution1266 {
    public static void main(String[] args) {
        int[][] points = {
                {1, 1},
                {3, 4},
                {-1, 0},
        };
        int i = new Solution1266().minTimeToVisitAllPoints(points);
        System.out.println("i = " + i);
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int rs = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int[] from = points[i];
            int[] to = points[i + 1];

            int t = 0;
            int fromX = from[0];
            int fromY = from[1];

            int toX = to[0];
            int toY = to[1];

            int absXGap = Math.abs(fromX - toX);
            int absYGap = Math.abs(fromY - toY);

            if (absXGap == absYGap) {
                t += absXGap;
            } else {
                t += Math.max(absXGap, absYGap);
            }
            rs += t;
        }

        return rs;
    }
}

package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution1637 {
    public static void main(String[] args) {
        int[][] points = {
                {8, 7},
                {9, 9},
                {7, 4},
                {9, 7},
        };
        int rs = new Solution1637().maxWidthOfVerticalArea(points);
        System.out.println("rs = " + rs);
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] pointX = new int[n];
        for (int i = 0; i < n; i++) {
            pointX[i] = points[i][0];
        }
        Arrays.sort(pointX);

        int rs = 0;
        for (int i = 0; i < n - 1; i++) {
            int gap = pointX[i + 1] - pointX[i];
            rs = Math.max(rs, gap);
        }
        
        return rs;
    }
}

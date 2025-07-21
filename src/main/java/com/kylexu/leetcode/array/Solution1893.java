package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution1893 {
    public static void main(String[] args) {
//        ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
        int left = 2, right = 5;
        boolean covered = new Solution1893().isCovered(ranges, left, right);
        System.out.println("covered = " + covered);
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] range : ranges) {
            if (range[0] <= left && range[1] >= left) {
                left = range[1] + 1;
            }
        }

        return left > right;
    }
}

package com.kylexu.leetcode.matrix;

import java.util.Arrays;

public class Solution661 {
    public static void main(String[] args) {
        int[][] img = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        int[][] ints = new Solution661().imageSmoother(img);
        System.out.println("ints = " + Arrays.deepToString(ints));
    }

    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = genValue(i, j, m, n, img, dx, dy);
            }
        }
        return res;
    }

    private int genValue(int i, int j, int m, int n, int[][] img, int[] dx, int[] dy) {
        int num = 1, sum = img[i][j];
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < m && y < n) {
                num++;
                sum += img[x][y];
            }

        }
        return sum / num;
    }
}

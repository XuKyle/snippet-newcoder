package com.kylexu.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution1260 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        List<List<Integer>> lists = new Solution1260().shiftGrid(grid, k);
        System.out.println("lists = " + lists);
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> rs = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    rs.add(new ArrayList<>());
                }
                rs.get(i).add(0);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int y = (j + k) % n;
                int x = (i + (k + j) / n) % m;
                rs.get(x).set(y, grid[i][j]);
            }
        }

        return rs;
    }
}

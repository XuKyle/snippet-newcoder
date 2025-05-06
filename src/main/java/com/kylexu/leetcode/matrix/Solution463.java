package com.kylexu.leetcode.matrix;

public class Solution463 {
    public static void main(String[] args) {
//        grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//        int[][] grid = {
//                {0, 1, 0, 0},
//                {1, 1, 1, 0},
//                {0, 1, 0, 0},
//                {1, 1, 0, 0}
//        };
        int[][] grid = {{1, 0}};
        int rs = new Solution463().islandPerimeter(grid);
        System.out.println("rs = " + rs);
    }

    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int rs = 0;
        for (int i = 0; i < row; i++) {
            int[] currentRow = grid[i];

            for (int j = 0; j < currentRow.length; j++) {
                int cell = currentRow[j];
                if (cell == 1) {
                    // 上
                    if (i == 0) {
                        rs++;
                    } else {
                        if (grid[i - 1][j] == 0) {
                            rs++;
                        }
                    }
                    // 下
                    if (i == row - 1) {
                        rs++;
                    } else {
                        if (grid[i + 1][j] == 0) {
                            rs++;
                        }
                    }

                    // 左
                    if (j == 0) {
                        rs++;
                    } else {
                        if (grid[i][j - 1] == 0) {
                            rs++;
                        }
                    }

                    // 右
                    if (j == currentRow.length - 1) {
                        rs++;
                    } else {
                        if (grid[i][j + 1] == 0) {
                            rs++;
                        }
                    }
                }
            }
        }

        return rs;
    }
}

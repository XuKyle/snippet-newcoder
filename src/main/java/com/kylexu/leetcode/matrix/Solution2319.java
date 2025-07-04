package com.kylexu.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution2319 {
    public static void main(String[] args) {
//        grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
        int[][] grid = {
                {2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}
        };
        boolean checked = new Solution2319().checkXMatrix(grid);
        System.out.println("checked = " + checked);
    }

    public boolean checkXMatrix(int[][] grid) {
        List<String> loc = new ArrayList<>();
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            int x = i;
            int y = x;
            loc.add(x + "," + y);

            int y1 = n - i - 1;
            int x1 = i;
            loc.add(x1 + "," + y1);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int num = grid[i][j];
                if (loc.contains(i + "," + j)) {
                    if (num == 0) {
                        return false;
                    }
                } else {
                    if (num != 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

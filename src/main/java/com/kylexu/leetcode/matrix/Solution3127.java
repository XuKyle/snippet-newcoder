package com.kylexu.leetcode.matrix;

public class Solution3127 {
    public static void main(String[] args) {
//        grid = [["B","W","B"],["B","W","W"],["B","W","B"]]
        char[][] grid = {
                {'B', 'W', 'B'},
                {'B', 'W', 'W'},
                {'B', 'W', 'B'},
        };
        boolean b = new Solution3127().canMakeSquare(grid);
        System.out.println("b = " + b);
    }

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int bCount = 0;
                int wCount = 0;
                if (grid[i][j] == 'B') {
                    bCount++;
                } else {
                    wCount++;
                }
                if (grid[i][j + 1] == 'B') {
                    bCount++;
                } else {
                    wCount++;
                }
                if (grid[i + 1][j] == 'B') {
                    bCount++;
                } else {
                    wCount++;
                }
                if (grid[i + 1][j + 1] == 'B') {
                    bCount++;
                } else {
                    wCount++;
                }

                if (bCount >= 3 || wCount >= 3) {
                    return true;
                }
            }
        }

        return false;
    }
}

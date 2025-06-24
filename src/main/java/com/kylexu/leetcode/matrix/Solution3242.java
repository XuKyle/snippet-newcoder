package com.kylexu.leetcode.matrix;

public class Solution3242 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        NeighborSum neighborSum = new NeighborSum(grid);
        System.out.println(neighborSum.adjacentSum(1));
        System.out.println(neighborSum.adjacentSum(4));
        System.out.println(neighborSum.diagonalSum(4));
        System.out.println(neighborSum.diagonalSum(8));
    }
}

/**
 * ["neighborSum", "adjacentSum", "adjacentSum", "diagonalSum", "diagonalSum"]
 * <p>
 * [[[[0, 1, 2], [3, 4, 5], [6, 7, 8]]], [1], [4], [4], [8]]
 * <p>
 * 输出： [null, 6, 16, 16, 4]
 */
class NeighborSum {
    private int[][] grid;
    private int n;
    private int x;
    private int y;

    public NeighborSum(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
    }

    private void findCore(int value) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == value) {
                    this.x = i;
                    this.y = j;
                }
            }
        }
    }

    public int adjacentSum(int value) {
        int sum = 0;
        findCore(value);

        // 上
        if (x > 0) {
            sum += grid[x - 1][y];
        }
        // 下
        if (x < n - 1) {
            sum += grid[x + 1][y];
        }
        // 左
        if (y > 0) {
            sum += grid[x][y - 1];
        }
        // 右
        if (y < n - 1) {
            sum += grid[x][y + 1];
        }

        return sum;
    }

    public int diagonalSum(int value) {
        int sum = 0;
        findCore(value);


        if (x > 0) {
            // 左上
            if (y > 0) {
                sum += grid[x - 1][y - 1];
            }
            // 左下
            if (y < n - 1) {
                sum += grid[x - 1][y + 1];
            }
        }

        if (x < n - 1) {
            // 右上
            if (y > 0) {
                sum += grid[x + 1][y - 1];
            }
            // 右下
            if (y < n - 1) {
                sum += grid[x + 1][y + 1];
            }
        }

        return sum;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */

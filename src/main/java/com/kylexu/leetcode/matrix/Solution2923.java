package com.kylexu.leetcode.matrix;

/**
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1],[0,0]]
 * 输出：0
 * 解释：比赛中有两支队伍。
 * grid[0][1] == 1 表示 0 队比 1 队强。所以 0 队是冠军。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,1],[1,0,1],[0,0,0]]
 * 输出：1
 * 解释：比赛中有三支队伍。
 * grid[1][0] == 1 表示 1 队比 0 队强。
 * grid[1][2] == 1 表示 1 队比 2 队强。
 * 所以 1 队是冠军。
 */
public class Solution2923 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1},
                {1, 0, 1},
                {0, 0, 0}
        };
        int champion = new Solution2923().findChampion(grid);
        System.out.println("champion = " + champion);
    }

    public int findChampion(int[][] grid) {
        int n = grid.length;
        int winner = 0;
        for (int i = 1; i < n; i++) {
            if (grid[winner][i] <= 0) {
                winner = i;
            }
        }

        return winner;
    }
}

package com.kylexu.leetcode.other;

import java.util.Arrays;
import java.util.Objects;

/**
 * 输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * 输出："A"
 * 解释："A" 获胜，他总是先走。
 * <p>
 * 输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * 输出："B"
 * 解释："B" 获胜。
 * <p>
 * 输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * 输出："Draw"
 * 解释：由于没有办法再行动，游戏以平局结束。
 */
public class Solution1275 {
    public static void main(String[] args) {
//        int[][] moves = {{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
        int[][] moves = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
//        [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
        // todo
        System.out.println(new Solution1275().tictactoe(moves));
    }

    public String tictactoe(int[][] moves) {
        String[][] rs = new String[3][3];

        for (int i = 0; i < moves.length; i++) {
            int left = moves[i][0];
            int right = moves[i][1];
            if (i % 2 == 0) {
                rs[left][right] = "A";
            } else {
                rs[left][right] = "B";
            }
        }

        System.out.println(Arrays.deepToString(rs));

        String result = null;

        for (String[] r : rs) {
            if (Objects.equals(r[0], r[1]) && Objects.equals(r[1], r[2])) {
                result = r[0];
                break;
            }
        }

        if (Objects.equals(rs[0][0], rs[1][1]) && Objects.equals(rs[2][2], rs[1][1])) {
            result = rs[0][0];
        }

        if (Objects.equals(rs[0][2], rs[1][1]) && Objects.equals(rs[2][0], rs[1][1])) {
            result = rs[0][2];
        }

        if (result == null) {
            return "Pending";
        }

        return "Draw";
    }
}

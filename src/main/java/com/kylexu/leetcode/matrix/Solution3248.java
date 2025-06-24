package com.kylexu.leetcode.matrix;

import java.util.List;

public class Solution3248 {
    public static void main(String[] args) {
        int n = 2;
        List<String> commands = List.of("RIGHT", "DOWN");
        int i = new Solution3248().finalPositionOfSnake(n, commands);
        System.out.println("i = " + i);
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (i * n) + j;
            }
        }

        int i = 0;
        int j = 0;
        for (String command : commands) {
            switch (command) {
                case "UP":
                    i--;
                    break;
                case "RIGHT":
                    j++;
                    break;
                case "DOWN":
                    i++;
                    break;
                case "LEFT":
                    j--;
                    break;
                default:
            }
        }

        return matrix[i][j];
    }
}

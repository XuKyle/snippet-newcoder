package com.kylexu.leetcode.matrix;

public class Solution74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        boolean b = new Solution74().searchMatrix(matrix, target);
        System.out.println("b = " + b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean rs = false;

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (target == anInt) {
                    return true;
                }
                if (target < anInt) {
                    return false;
                }
            }
        }

        return rs;
    }
}

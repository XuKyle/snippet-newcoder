package com.kylexu.leetcode.matrix;

import java.util.Arrays;

/**
 * 输入：brackets = [[3,50],[7,10],[12,25]], income = 10
 */
public class Solution2303 {
    public static void main(String[] args) {
//        int[][] brackets = new int[][]{
//                {1, 0},
//                {4, 25},
//                {5, 50}
//        };
//        int income = 2;

        int[][] brackets = new int[][]{
                {3, 50},
                {7, 10},
                {12, 25}
        };
        int income = 10;

//        输入：brackets = [[1,0],[4,25],[5,50]], income = 2   => 0.25
//        输入：brackets = [[3,50],[7,10],[12,25]], income = 10  => 2.65

        System.out.println(new Solution2303().calculateTax(brackets, income));
    }

    public double calculateTax(int[][] brackets, int income) {
        double rs = 0;
        int[] segs = new int[brackets.length];

        for (int i = 0; i < segs.length; i++) {
            int currentIncome = brackets[i][0];
            if (currentIncome >= income) {
                if (i == 0) {
                    segs[i] = income;
                } else {
                    segs[i] = income - brackets[i - 1][0];
                }
                break;
            } else {
                if (i == 0) {
                    segs[i] = currentIncome;
                } else {
                    segs[i] = currentIncome - brackets[i - 1][0];
                }
            }
        }

        for (int i = 0; i < segs.length; i++) {
            double v = segs[i] * 1.0 * brackets[i][1] / 100;
            rs += v;
            System.out.println("v:" + v + " rs = " + rs);
        }

        return rs;
    }
}

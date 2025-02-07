package com.kylexu.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution3417 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
//[2,1],[2,1],[2,1]
//        int[][] grid = {
//                {2, 1},
//                {2, 1},
//                {2, 1},
//        };
        List<Integer> rs = new Solution3417().zigzagTraversal(grid);
        System.out.println("rs = " + rs);
    }

    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> rs = new ArrayList<>();

        List<Integer> flat = new ArrayList<>();
        boolean reversed = false;
        for (int[] temp : grid) {
            if (reversed) {
                for (int i = temp.length - 1; i >= 0; i--) {
                    flat.add(temp[i]);
                }
            } else {
                for (int i : temp) {
                    flat.add(i);
                }
            }
            reversed = !reversed;
        }

        for (int i = 0; i < flat.size(); i++) {
            if (i % 2 == 0) {
                rs.add(flat.get(i));
            }
        }
        return rs;
    }
}

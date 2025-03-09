package com.kylexu.leetcode.matrix;

public class Solution1582 {
    public static void main(String[] args) {
//        int[][] mat = {
//                {0, 0, 1, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 1, 0, 0}
//        };

        int[][] mat = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

//        int[][] mat = {
//                {0, 0}, {0, 0}, {1, 0}
//        };
        System.out.println(new Solution1582().numSpecial(mat));
    }

    public int numSpecial(int[][] mat) {
        int rs = 0;
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            boolean flag = true;
            int sumRow = 0;
            int currentOneIndex = -1;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    currentOneIndex = j;
                } else if (mat[i][j] != 0) {
                    flag = false;
                    break;
                }
                sumRow += mat[i][j];
            }

            flag = flag && sumRow == 1;
            if (flag && currentOneIndex != -1) {
                for (int j = 0; j < m; j++) {
                    if (j == i) {
                        continue;
                    }
                    if (mat[j][currentOneIndex] != 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    rs++;
                }
            }
        }

        return rs;
    }
}

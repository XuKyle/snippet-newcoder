package com.kylexu.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution498 {
    public static void main(String[] args) {
//        mat = [[1,2,3],[4,5,6],[7,8,9]]
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] diagonalOrder = new Solution498().findDiagonalOrder(mat);
        System.out.println("diagonalOrder = " + Arrays.toString(diagonalOrder));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        boolean reverse = true;

        List<Integer> rs = new ArrayList<>();

        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < (m + n - 1); i++) {
            int x = i < n ? 0 : (i - n + 1);
            int y = Math.min(i, n - 1);

            List<Integer> current = new ArrayList<>();

            for (; ; ) {
                current.add(mat[x][y]);
                if (lastPosition(x, y, m)) {
                    break;
                }
                x++;
                y--;
            }

            if (reverse) {
                for (int j = current.size() - 1; j >= 0; j--) {
                    rs.add(current.get(j));
                }
            } else {
                rs.addAll(current);
            }

            reverse = !reverse;
        }

        return rs.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean lastPosition(int x, int y, int m) {
        return y == 0 || x == (m - 1);
    }
}

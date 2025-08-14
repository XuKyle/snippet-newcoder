package com.kylexu.leetcode.matrix;

public class Solution2946 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}};
        int k = 2;
        boolean b = new Solution2946().areSimilar(mat, k);
        System.out.println("b = " + b);
    }

    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        k %= n;
        if (k == 0) {
            return true;
        }

        for (int[] r : mat) {
            for (int j = 0; j < n; j++) {
                if (r[j] != r[(j + k) % n]) {
                    return false;
                }
            }
        }

        return true;
    }
}

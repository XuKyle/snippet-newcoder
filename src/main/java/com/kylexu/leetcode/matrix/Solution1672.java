package com.kylexu.leetcode.matrix;

public class Solution1672 {
    public static void main(String[] args) {
        int[][] accounts = {
                {1, 2, 3},
                {3, 2, 1}
        };
        System.out.println(new Solution1672().maximumWealth(accounts));
    }

    public int maximumWealth(int[][] accounts) {
        int rs = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            rs = Math.max(sum, rs);
        }
        return rs;
    }
}

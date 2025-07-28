package com.kylexu.leetcode.matrix;

public class Solution2614 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11},
        };
        int i = new Solution2614().diagonalPrime(nums);
        System.out.println("i = " + i);
    }

    public int diagonalPrime(int[][] nums) {
        int rs = 0;

//        如果存在整数 i ，使得 nums[i][i] = val 或者 nums[i][nums.length - i - 1]= val ，则认为整数 val 位于 nums 的一条对角线上。
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) {
                rs = Math.max(rs, nums[i][i]);
            }
            if (isPrime(nums[i][n - i - 1])) {
                rs = Math.max(rs, nums[i][n - i - 1]);
            }
        }

        return rs;
    }

    private boolean isPrime(int n) {
        if(n<=1) return false;
        for(int i=2;i*i<=n;++i) if(n%i==0) return false;
        return true;
    }
}

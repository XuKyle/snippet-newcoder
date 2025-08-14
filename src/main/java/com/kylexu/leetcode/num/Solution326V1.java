package com.kylexu.leetcode.num;

public class Solution326V1 {
    public static void main(String[] args) {
//        输入：n = 27
//        输出：true
        int n = 27;
        boolean powerOfThree = new Solution326V1().isPowerOfThree(n);
        System.out.println("powerOfThree = " + powerOfThree);
    }

    public boolean isPowerOfThree(int n) {
        for (int i = 0; i < n; i++) {
            double pow = Math.pow(3, i);
            if (pow > n) {
                return false;
            } else if (pow == n) {
                return true;
            }
        }

        return false;
    }
}

package com.kylexu.leetcode.num;

public class Solution342V1 {
    public static void main(String[] args) {
        int n = 1;
        boolean powerOfFour = new Solution342V1().isPowerOfFour(n);
        System.out.println("powerOfFour = " + powerOfFour);
    }

    public boolean isPowerOfFour(int n) {
        if (n == 1 || n ==0) {
            return true;
        }

        while (n % 4 == 0) {
            n = n / 4;
        }



        return false;
    }
}

package com.kylexu.leetcode.num;

public class Solution1780 {
    public static void main(String[] args) {
        int n = 12;
        boolean b = new Solution1780().checkPowersOfThree(n);
        System.out.println("b = " + b);
    }

    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}

package com.kylexu.leetcode.num;

public class Solution2119 {
    public static void main(String[] args) {
        System.out.println(new Solution2119().isSameAfterReversals(526));
    }

    public boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }

        if (num % 10 == 0) {
            return false;
        }

        return true;
    }
}

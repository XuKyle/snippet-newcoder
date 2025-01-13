package com.kylexu.leetcode.num;

import java.util.Arrays;

public class Solution1317 {
    public static void main(String[] args) {
        int n = 71;
        System.out.println(Arrays.toString(new Solution1317().getNoZeroIntegers(n)));
    }

    public int[] getNoZeroIntegers(int n) {
        int left = 1;
        int right = n - left;

        while (zero(right) || zero(left)) {
            left++;
            right = n - left;
        }

        int[] rs = new int[2];
        rs[0] = left;
        rs[1] = right;
        return rs;
    }

    public boolean zero(int n) {
        for (char c : String.valueOf(n).toCharArray()) {
            if (c == '0') {
                return true;
            }
        }
        return false;
    }
}

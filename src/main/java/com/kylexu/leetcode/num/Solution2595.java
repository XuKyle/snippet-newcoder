package com.kylexu.leetcode.num;

import java.util.Arrays;

public class Solution2595 {
    public static void main(String[] args) {
        int n = 2;
        int[] rs = new Solution2595().evenOddBit(n);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] evenOddBit(int n) {
        String binaryString = Integer.toBinaryString(n);
        int m = binaryString.length();

        int even = 0;
        int odd = 0;
        for (int i = m - 1; i >= 0; i--) {
            int index = m - 1 - i;
            if (index % 2 == 0 && binaryString.charAt(i) == '1') {
                even++;
            }

            if (index % 2 == 1 && binaryString.charAt(i) == '1') {
                odd++;
            }
        }
        return new int[]{even, odd};
    }
}

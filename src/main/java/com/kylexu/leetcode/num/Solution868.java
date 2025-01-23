package com.kylexu.leetcode.num;

public class Solution868 {
    public static void main(String[] args) {
        int n = 22;
        System.out.println(new Solution868().binaryGap(n));
    }

    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);

        int max = 0;
        int left = -1;

        int m = binaryString.length();

        for (int i = 0; i < m; i++) {
            char current = binaryString.charAt(i);
            if (current == '1') {
                if (left != -1) {
                    max = Math.max(max, i - left);
                }
                left = i;
            }
        }
        return max;
    }
}

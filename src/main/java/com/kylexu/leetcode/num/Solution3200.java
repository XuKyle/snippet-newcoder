package com.kylexu.leetcode.num;

import java.util.Arrays;

public class Solution3200 {
    public static void main(String[] args) {
        int red = 2;
        int blue = 4;

        int rs = new Solution3200().maxHeightOfTriangle(red, blue);
        System.out.println("rs = " + rs);
    }

    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(max(red, blue), max(blue, red));
    }

    private int max(int a, int b) {
        for (int i = 1; ; i++) {
            if (i % 2 == 1) {
                if (a >= i) {
                    a = a - i;
                } else {
                    return i - 1;
                }
            } else {
                if (b >= i) {
                    b = b - i;
                } else {
                    return i - 1;
                }
            }
        }
    }
}

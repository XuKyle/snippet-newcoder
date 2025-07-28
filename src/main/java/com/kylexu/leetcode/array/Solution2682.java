package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution2682 {
    public static void main(String[] args) {
        int n = 4, k = 4;
        int[] rs = new Solution2682().circularGameLosers(n, k);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] circularGameLosers(int n, int k) {
        int[] mark = new int[n];
        int step = k;
        int index = 0;
        mark[index] = 1;

        while (true) {
            index = (index + step) % n;
            mark[index] += 1;
            if (mark[index] >= 2) {
                break;
            }
            step += k;
        }

        int sum = 0;
        for (int i : mark) {
            if (i == 0) {
                sum++;
            }
        }

        int[] rs = new int[sum];
        int i = 0;
        for (int j = 0; j < mark.length; j++) {
            if (mark[j] == 0) {
                rs[i++] = j + 1;
            }
        }

        return rs;
    }
}

package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution2558 {
    public static void main(String[] args) {
        int[] gifts = {54, 6, 34, 66, 63, 52, 39, 62, 46, 75, 28, 65, 18, 37, 18, 13, 33, 69, 19, 40, 13, 10, 43, 61, 72};
        int k = 7;
        long rs = new Solution2558().pickGifts(gifts, k);
        System.out.println("rs = " + rs);
    }

    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length - 1;
        for (int i = 0; i < k; i++) {
            Arrays.sort(gifts);
            gifts[n] = (int) Math.floor(Math.sqrt(gifts[n]));
        }

        long sum = 0;
        for (long gift : gifts) {
            sum += gift;
        }
        return sum;
    }
}

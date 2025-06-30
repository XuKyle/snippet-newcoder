package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution2553 {
    public static void main(String[] args) {
        int[] nums = {13, 25, 83, 77};
        int[] rs = new Solution2553().separateDigits(nums);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] separateDigits(int[] nums) {

        return Arrays.stream(nums)
                .flatMap(
                        num -> {
                            String s = String.valueOf(num);
                            int[] r = new int[s.length()];
                            for (int i = 0; i < s.length(); i++) {
                                r[i] = s.charAt(i) - '0';
                            }
                            return Arrays.stream(r);
                        }
                ).toArray();
    }
}

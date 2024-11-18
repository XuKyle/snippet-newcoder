package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution3264 {
    public static void main(String[] args) {
//        nums = [2,1,3,5,6], k = 5, multiplier = 2
        int[] nums = new int[]{2, 1, 3, 5, 6};
        int[] finalState = new Solution3264().getFinalState(nums, 5, 2);
        System.out.println("finalState = " + Arrays.toString(finalState));
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (k == 0) {
            return nums;
        }

        int min = Integer.MAX_VALUE;
        int minPosition = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < min) {
                min = num;
                minPosition = i;
            }
        }
        nums[minPosition] *= multiplier;

        return getFinalState(nums, k - 1, multiplier);
    }
}

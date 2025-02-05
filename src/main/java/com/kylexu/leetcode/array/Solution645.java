package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution645 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        int[] errorNums = new Solution645().findErrorNums(nums);
        System.out.println("errorNums = " + Arrays.toString(errorNums));
    }

    public int[] findErrorNums(int[] nums) {
        int sum = 0;
        int sumReal = 0;
        Set<Integer> mark = new HashSet<>();
        int repeat = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (mark.contains(num)) {
                repeat = num;
            } else {
                mark.add(num);
            }
            sum += (i + 1);
            sumReal += num;
        }
        return new int[]{repeat, sum - sumReal + repeat};
    }
}

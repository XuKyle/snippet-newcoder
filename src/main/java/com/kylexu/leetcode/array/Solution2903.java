package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution2903 {
    public static void main(String[] args) {
//        nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
        int[] nums = {5, 1, 4, 1};
        int indexDifference = 2, valueDifference = 4;
        int[] indices = new Solution2903().findIndices(nums, indexDifference, valueDifference);
        System.out.println("indices = " + Arrays.toString(indices));
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
//        你的任务是从范围 [0, n - 1] 内找出  2 个满足下述所有条件的下标 i 和 j ：
//
//        abs(i - j) >= indexDifference 且
//        abs(nums[i] - nums[j]) >= valueDifference
        int a = -1;
        int b = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        return new int[]{a, b};
    }
}

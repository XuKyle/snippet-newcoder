package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution1995 {
    public static void main(String[] args) {
        int[] nums = {28, 8, 49, 85, 37, 90, 20, 8};
        int i = new Solution1995().countQuadruplets(nums);
        System.out.println("i = " + i);
    }

    public int countQuadruplets(int[] nums) {
//        Arrays.sort(nums);
        int rs = 0;
        System.out.println("nums = " + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] < nums[l]) {
                            continue;
                        }

                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            System.out.println("nums[i] + \"+\" + nums[j] + \"+\" + nums[k] + \"=\" + nums[l] = " + nums[i] + "+" + nums[j] + "+" + nums[k] + "=" + nums[l]);
                            rs++;
                        }
                    }
                }
            }
        }

        return rs;
    }
}

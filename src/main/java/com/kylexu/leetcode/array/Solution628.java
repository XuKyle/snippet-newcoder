package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution628 {
    public static void main(String[] args) {
        int[] nums = new int[]{722, 634, -504, -379, 163, -613, -842, -578, 750, 951, -158, 30, -238, -392, -487, -797, -157, -374, 999, -5, -521, -879, -858, 382, 626, 803, -347, 903, -205, 57, -342, 186, -736, 17, 83, 726, -960, 343, -984, 937, -758, -122, 577, -595, -544, -559, 903, -183, 192, 825, 368, -674, 57, -959, 884, 29, -681, -339, 582, 969, -95, -455, -275, 205, -548, 79, 258, 35, 233, 203, 20, -936, 878, -868, -458, -882, 867, -664, -892, -687, 322, 844, -745, 447, -909, -586, 69, -88, 88, 445, -553, -666, 130, -640, -918, -7, -420, -368, 250, -786
        };
        System.out.println(new Solution628().maximumProduct(nums));
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int positiveCnt = 0;
        for (int num : nums) {
            if (num > 0) {
                positiveCnt++;
            }
        }

        if (positiveCnt == 0) {
            return nums[n - 1] * nums[n - 2] * nums[n - 3];
        }

        if (positiveCnt < 3) {
            return nums[0] * nums[1] * nums[n - 1];
        }

        int rs1 = nums[0] * nums[1] * nums[n - 1];
        int rs2 = nums[n - 3] * nums[n - 2] * nums[n - 1];
        return Math.max(rs1, rs2);
    }
}

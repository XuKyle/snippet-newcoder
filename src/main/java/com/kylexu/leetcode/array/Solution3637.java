package com.kylexu.leetcode.array;

public class Solution3637 {
    public static void main(String[] args) {
        int[] nums = {8, 6, 3, 5};
        boolean trionic = new Solution3637().isTrionic(nums);
        System.out.println("trionic = " + trionic);
    }

    public boolean isTrionic(int[] nums) {
        int a = -1, b = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }

            if (a == -1) {
                if (nums[i] > nums[i + 1]) {
                    a = i;
                }
            } else {
                if (b == -1) {
                    if (nums[i] < nums[i + 1]) {
                        b = i;
                    }
                } else {
                    if (nums[i] > nums[i + 1]) {
                        return false;
                    }
                }

            }
        }

        return a != 0 && b != -1 && a < b;
    }
}

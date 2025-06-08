package com.kylexu.leetcode.array;

public class Solution2210 {
    public static void main(String[] args) {
        int[] nums = {6, 6, 5, 5, 4, 1};
        int rs = new Solution2210().countHillValley(nums);
        System.out.println("rs = " + rs);
    }

    public int countHillValley(int[] nums) {
        int rs = 0;

        // 峰的数量
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1]) {
                int j = i + 1;
                while (j < nums.length - 1 && nums[i] == nums[j]) {
                    j++;
                }

                if (nums[i] > nums[j]) {
                    rs++;
                    i = j;
                }
            }
        }

        // 峰的数量
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < nums[i - 1]) {
                int j = i + 1;
                while (j < nums.length - 1 && nums[i] == nums[j]) {
                    j++;
                }

                if (nums[i] < nums[j]) {
                    rs++;
                    i = j;
                }
            }
        }


        return rs;
    }
}

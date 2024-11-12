package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution26 {

    public static void main(String[] args) {
//        输入：nums = [0,0,1,1,1,2,2,3,3,4]
//        输出：5, nums = [0,1,2,3,4]
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Solution26().removeDuplicates(ints));
        System.out.println("ints = " + Arrays.toString(ints));
    }


    public int removeDuplicates(int[] nums) {
        int current = nums[0];
        int rs = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != current) {
                rs++;
                nums[rs] = nums[i];
                current = nums[i];
            }
        }
        return rs + 1;
    }

}

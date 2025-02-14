package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * 你可以返回 任何满足上述条件的数组作为答案 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3]
 * 输出：[2,3]
 */
public class Solution922 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2};
        int[] ints = new Solution922().sortArrayByParityII(nums);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;

        int oddIndex = 1;
        int evenIndex = 0;

        while (oddIndex < n || evenIndex < n) {
            while (oddIndex < n && nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }
            while (evenIndex < n && nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }

            if (evenIndex < n && oddIndex < n && nums[oddIndex] % 2 != 1 && nums[evenIndex] % 2 != 0) {
                int temp = nums[oddIndex];
                nums[oddIndex] = nums[evenIndex];
                nums[evenIndex] = temp;

                oddIndex += 2;
                evenIndex += 2;
            }
        }

        return nums;
    }
}

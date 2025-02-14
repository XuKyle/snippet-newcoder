package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 */
public class Solution905 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        int[] ints = new Solution905().sortArrayByParity(nums);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right && left < n && right < n) {
            while (left < n && nums[left] % 2 == 0) {
                left++;
            }

            while (right >= 0 && nums[right] % 2 == 1) {
                right--;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
        return nums;
    }
}

package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：true
 * 解释：[1,2,3,4,5] 为有序的源数组。
 * 可以轮转 x = 3 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,3,4]
 * 输出：false
 * 解释：源数组无法经轮转得到 nums 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：true
 * 解释：[1,2,3] 为有序的源数组。
 * 可以轮转 x = 0 个位置（即不轮转）得到 nums 。
 */
public class Solution1752 {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 10, 6};
        System.out.println(new Solution1752().check(nums));
    }

    public boolean check(int[] nums) {
        int n = nums.length;

        int maxIndex = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                maxIndex = i;
                break;
            }
            if (i == n - 2 && maxIndex == -1) {
                maxIndex = n - 1;
            }
        }
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);

        for (int i = 0; i < n; i++) {
            int copyIndex = (i + maxIndex + 1) % n;
            if (nums[copyIndex] != copy[i]) {
                return false;
            }
        }
        return true;
    }
}

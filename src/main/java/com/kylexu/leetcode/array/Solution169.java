package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class Solution169 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution169().majorityElement(nums));
        System.out.println(new Solution169().majorityElement(new int[]{3, 2, 3}));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int partitionIndex = partition(nums, low, high);

        quickSort(nums, 0, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, high);
    }

    private int partition(int[] nums, int startIndex, int endIndex) {
        int pivot = nums[startIndex];

        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (nums[right] > pivot && left < right) {
                right--;
            }

            while (nums[left] <= pivot && left < right) {
                left++;
            }

            if (left < right) {
                swap(nums, left, right);
            }
        }

        nums[startIndex] = nums[left];
        nums[left] = pivot;

        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

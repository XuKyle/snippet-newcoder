package com.kylexu.leetcode.company.jd;

import java.util.Arrays;

public class Solution912 {
    public static void main(String[] args) {
//        输入：nums = [5,2,3,1]
//        输出：[1,2,3,5]
        int[] nums = {5, 2, 3, 1};
        int[] sorted = new Solution912().sortArray(nums);
        System.out.println("sorted = " + Arrays.toString(sorted));
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = partition(nums, startIndex, endIndex);
        quickSort(nums, startIndex, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, endIndex);
    }

    private int partition(int[] nums, int startIndex, int endIndex) {
        int pivot = nums[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }

            while (left < right && nums[left] <= pivot) {
                left++;
            }

            if (left < right) {
                swap(nums, left, right);
            }
        }

        swap(nums, startIndex, left);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package com.kylexu.leetcode.sort;

import java.util.Arrays;

public class Solution912 {
//    给你一个整数数组 nums，请你将该数组升序排列。
//
//    你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
//
//
//
//    示例 1：
//
//    输入：nums = [5,2,3,1]
//    输出：[1,2,3,5]

    public static void main(String[] args) {
        int[] ints = {5, 2, 3, 1};
        int[] sorted = new Solution912().sortArray(ints);
        System.out.println("sorted = " + Arrays.toString(sorted));
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }
}

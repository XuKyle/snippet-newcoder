package com.kylexu.leetcode.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
public class Solution35 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};

        System.out.println(new Solution35().searchInsert(nums, 5));
        System.out.println(new Solution35().searchInsert(nums, 2));
        System.out.println(new Solution35().searchInsert(nums, 7));
    }


    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

//        为什么直接return left；因为如果上面的没有返回return middle，说明最后一定是，
//        left>right从而跳出循环的，在此之前是left=right，如果最后是right-1导致的left>right，
//        说明原来的right位置是大于target的，所以返回原来的right位置即left位置；
//        如果最后是left+1导致的left>right,说明是原来的的left=right这个位置小于target，而right能移动到这个位置，
//        说明此位置右侧是大于target的，left现在加1就移动到了这样的位置，返回left即可


        return left;
    }
}

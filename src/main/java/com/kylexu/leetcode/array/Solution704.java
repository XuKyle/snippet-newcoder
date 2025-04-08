package com.kylexu.leetcode.array;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
public class Solution704 {
    public static void main(String[] args) {
        int target = 5;
        int[] nums = new int[]{5};
        System.out.println(new Solution704().search(nums, target));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 写二分法，区间的定义一般为两种，左闭右闭即[left, right]，或者左闭右开即[left, right)。

        // 区间的定义这就决定了二分法的代码应该如何写，因为定义target在[left, right]区间，所以有如下两点：
        //
        //  while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
        //  if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，
        //  那么接下来要查找的左区间结束下标位置就是 middle - 1
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
        return -1;
    }
}

package com.kylexu.leetcode.company.jd;

public class Solution53 {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
//        示例 1：
//
//        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//        输出：6
//        解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//        示例 2：
//
//        输入：nums = [1]
//        输出：1
//        示例 3：
//
//        输入：nums = [5,4,-1,7,8]
//        输出：23

        int[] nums = new int[]{5, 4, -1, 7, 8};
        System.out.println(new Solution53().maxSubArray(nums));
    }
}

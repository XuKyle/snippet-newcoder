package com.kylexu.leetcode.array;

import java.util.*;


/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 */
public class Solution15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> rs = new Solution15().threeSum(nums);
        System.out.println("rs = " + rs);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int first = 0; first < n; first++) {
            // 如果跟上一个位置的一样
            if (first != 0 && nums[first - 1] == nums[first]) {
                continue;
            }

            int third = n - 1;
            int target = -1 * nums[first];
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (nums[second] + nums[third] > target && second < third) {
                    third--;
                }

                if (second == third) {
                    break;
                }

                if (nums[first] + nums[second] + nums[third] == 0) {
                    rs.add(List.of(nums[first], nums[second], nums[third]));
                }
            }
        }
        return rs;
    }
}

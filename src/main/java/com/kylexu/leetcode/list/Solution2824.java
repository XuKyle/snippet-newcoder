package com.kylexu.leetcode.list;

import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [-1,1,2,3,1], target = 2
 * 输出：3
 * 解释：总共有 3 个下标对满足题目描述：
 * - (0, 1) ，0 < 1 且 nums[0] + nums[1] = 0 < target
 * - (0, 2) ，0 < 2 且 nums[0] + nums[2] = 1 < target
 * - (0, 4) ，0 < 4 且 nums[0] + nums[4] = 0 < target
 * 注意 (0, 3) 不计入答案因为 nums[0] + nums[3] 不是严格小于 target 。
 * 示例 2：
 * <p>
 * 输入：nums = [-6,2,5,-2,-7,-1,3], target = -2
 * 输出：10
 * 解释：总共有 10 个下标对满足题目描述：
 */
public class Solution2824 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(-6, 2, 5, -2, -7, -1, 3);
        int target = -2;
        System.out.println(new Solution2824().countPairs(nums, target));
    }

    public int countPairs(List<Integer> nums, int target) {
        int rs = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    rs++;
                }
            }
        }

        return rs;
    }
}

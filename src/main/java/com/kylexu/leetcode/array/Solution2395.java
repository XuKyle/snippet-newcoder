package com.kylexu.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,4]
 * 输出：true
 * 解释：元素为 [4,2] 和 [2,4] 的子数组有相同的和 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：false
 * 解释：没有长度为 2 的两个子数组和相等。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：true
 * 解释：子数组 [nums[0],nums[1]] 和 [nums[1],nums[2]] 的和相等，都为 0 。
 * 注意即使子数组的元素相同，这两个子数组也视为不相同的子数组，因为它们在原数组中的起始位置不同。
 */
public class Solution2395 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 4};
        System.out.println(new Solution2395().findSubarrays(nums));
    }

    public boolean findSubarrays(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (sets.contains(sum)) {
                return true;
            } else {
                sets.add(sum);
            }
        }

        return false;
    }
}

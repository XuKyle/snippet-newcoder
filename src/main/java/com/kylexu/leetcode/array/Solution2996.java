package com.kylexu.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2,5]
 * 输出：6
 * 解释：nums 的最长顺序前缀是 [1,2,3] ，和为 6 ，6 不在数组中，所以 6 是大于等于最长顺序前缀和的最小整数。
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5,1,12,14,13]
 * 输出：15
 * 解释：nums 的最长顺序前缀是 [3,4,5] ，和为 12 ，12、13 和 14 都在数组中，但 15 不在，所以 15 是大于等于最长顺序前缀和的最小整数。
 */
public class Solution2996 {
    public static void main(String[] args) {
        int[] nums = {38};
        int i = new Solution2996().missingInteger(nums);
        System.out.println("i = " + i);
    }

    public int missingInteger(int[] nums) {
        int sum = nums[0];
        boolean flag = true;
        Set<Integer> mark = new HashSet<>();
        mark.add(sum);

        for (int i = 1; i < nums.length; i++) {
            if (flag) {
                if (nums[i] == nums[i - 1] + 1) {
                    sum += nums[i];
                } else {
                    flag = false;
                }
            }
            mark.add(nums[i]);
        }

        while (mark.contains(sum)) {
            sum++;
        }

        return sum;
    }
}

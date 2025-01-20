package com.kylexu.leetcode.num;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0]
 * 输出：-1
 * 解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
 * 如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
 * 如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
 * 如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
 * x 不能取更大的值，因为 nums 中只有两个元素。
 * 示例 3：
 * <p>
 * 输入：nums = [0,4,3,0,4]
 * 输出：3
 * 解释：有 3 个元素大于或等于 3 。
 * 示例 4：
 * <p>
 * 输入：nums = [3,6,7,7,0]
 * 输出：-1
 */
public class Solution1608 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 7, 7, 0};
        System.out.println(new Solution1608().specialArray(nums));
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            int count = n - i;

            if (count <= value && count > max) {
                return count;
            }
            max = Math.max(max, value);
        }

        return -1;
    }
}

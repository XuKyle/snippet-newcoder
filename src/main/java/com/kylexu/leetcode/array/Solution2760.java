package com.kylexu.leetcode.array;

/**
 * 输入：nums = [3,2,5,4], threshold = 5
 * 输出：3
 * 解释：在这个示例中，我们选择从 l = 1 开始、到 r = 3 结束的子数组 => [2,5,4] ，满足上述条件。
 * 因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。
 * <p>
 * 请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
 * <p>
 * nums[l] % 2 == 0
 * 对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
 * 对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
 * 以整数形式返回满足题目要求的最长子数组的长度。
 */
public class Solution2760 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 4};
        int threshold = 5;
        int rs = new Solution2760().longestAlternatingSubarray(nums, threshold);
        System.out.println("rs = " + rs);
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int rs = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                continue;
            }

            int temp = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j - 1] % 2 == nums[j] % 2 || nums[j] > threshold) {
                    break;
                }
                temp++;
            }
            rs = Math.max(temp, rs);
        }

        return rs;
    }
}

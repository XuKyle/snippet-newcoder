package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * 输入：nums = [-2,-1,-1,1,2,3]
 * 输出：3
 * 解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [-3,-2,-1,0,0,1,2]
 * 输出：3
 * 解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,20,66,1314]
 * 输出：4
 * 解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
 */
public class Solution2529 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, -1, -1, 1, 2, 3};
        System.out.println(new Solution2529().maximumCount(nums));
    }

    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;

        for (int num : nums) {
            if (num < 0) {
                neg++;
            } else if (num > 0) {
                pos++;
            }
        }
        return Math.max(pos, neg);
    }
}

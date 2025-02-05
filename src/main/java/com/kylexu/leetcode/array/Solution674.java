package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 */
public class Solution674 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7};
        System.out.println(new Solution674().findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        int rs = 0;

        int l = 0;
        int r = 1;
        int n = nums.length;

        int tmp = l;
        while (r < n) {
            if (nums[r] > nums[tmp]) {
                r++;
                tmp++;
            } else {
                rs = Math.max(rs, r - l);

                l = r;
                r++;
                tmp = l;
            }
        }
        rs = Math.max(rs, r - l);

        return rs;
    }
}

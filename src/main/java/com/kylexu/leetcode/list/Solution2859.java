package com.kylexu.leetcode.list;

import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [5,10,1,5,2], k = 1
 * 输出：13
 * 解释：下标的二进制表示是：
 * 0 = 0002
 * 1 = 0012
 * 2 = 0102
 * 3 = 0112
 * 4 = 1002
 * 下标 1、2 和 4 在其二进制表示中都存在 k = 1 个置位。
 * 因此，答案为 nums[1] + nums[2] + nums[4] = 13 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,3,2,1], k = 2
 * 输出：1
 * 解释：下标的二进制表示是：
 * 0 = 002
 * 1 = 012
 * 2 = 102
 * 3 = 112
 * 只有下标 3 的二进制表示中存在 k = 2 个置位。
 * 因此，答案为 nums[3] = 1 。
 */
public class Solution2859 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(4, 3, 2, 1);
        int k = 2;
        int rs = new Solution2859().sumIndicesWithKSetBits(nums, k);
        System.out.println("rs = " + rs);
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int rs = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count(i) == k) {
                rs += nums.get(i);
            }
        }
        return rs;
    }

    private int count(Integer num) {
        int rs = 0;
        for (char c : Integer.toBinaryString(num).toCharArray()) {
            if (c == '1') {
                rs++;
            }
        }
        return rs;
    }
}

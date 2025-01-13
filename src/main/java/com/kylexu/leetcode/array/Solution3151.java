package com.kylexu.leetcode.array;

/**
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * 你有一个整数数组 nums。如果 nums 是一个 特殊数组 ，返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * 输入：nums = [1]
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 只有一个元素，所以答案为 true。
 * 示例 2：
 * 输入：nums = [2,1,4]
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 只有两对相邻元素： (2,1) 和 (1,4)，它们都包含了奇偶性不同的数字，因此答案为 true。
 * 示例 3：
 * <p>
 * 输入：nums = [4,3,1,6]
 * 输出：false
 * 解释：
 * <p>
 * nums[1] 和 nums[2] 都是奇数。因此答案为 false。
 */
public class Solution3151 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 1, 6};
        System.out.println(new Solution3151().isArraySpecial(nums));
    }

    public boolean isArraySpecial(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                return false;
            }
        }

        return true;
    }
}

package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * nums[2] = 2，其数位和等于 2 ，与其下标 i = 2 相等。因此，输出为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,11]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums[1] = 10，其数位和等于 1 + 0 = 1，与其下标 i = 1 相等。
 * nums[2] = 11，其数位和等于是 1 + 1 = 2，与其下标 i = 2 相等。
 * 由于下标 1 是满足要求的最小下标，输出为 1 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * <p>
 * 由于不存在满足要求的下标，输出为 -1
 */
public class Solution3550 {
    public static void main(String[] args) {
        int[] nums = {1, 10, 11};
        int rs = new Solution3550().smallestIndex(nums);
        System.out.println("rs = " + rs);
    }

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == sum(nums[i])) {
                return i;
            }
        }

        return -1;
    }

    public int sum(int num) {
        int rs = 0;
        while (num != 0) {
            rs += num % 10;
            num = num / 10;
        }
        return rs;
    }
}

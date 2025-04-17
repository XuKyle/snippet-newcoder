package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入： nums = [5,2,3,1]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 元素对 (3,1) 的和最小，为 4。替换后 nums = [5,2,4]。
 * 元素对 (2,4) 的和为 6。替换后 nums = [5,6]。
 * 数组 nums 在两次操作后变为非递减。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,2]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组 nums 已经是非递减的。
 */
public class Solution3507 {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        int rs = new Solution3507().minimumPairRemoval(nums);
        System.out.println("rs = " + rs);
    }

    public int minimumPairRemoval(int[] nums) {
        if (nonDecreasing(nums)) {
            return 0;
        }


        // todo
        return 0;
    }

    private boolean nonDecreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

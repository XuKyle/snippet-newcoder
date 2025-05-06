package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,1,4,5]
 * 输出：2
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,4,5] 。
 * - 删除前两个元素，分数为 1 + 4 = 5 ，nums = [5] 。
 * 由于只剩下 1 个元素，我们无法继续进行任何操作。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,6,1,4]
 * 输出：1
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
 * 由于下一次操作的分数与前一次不相等，我们无法继续进行任何操作。
 */
public class Solution3038 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5};
        System.out.println(new Solution3038().maxOperations(nums));
    }

    public int maxOperations(int[] nums) {
        int n = nums.length;
        int target = nums[0] + nums[1];
        int rs = 1;

        for (int i = 2; i + 1 < n; i += 2) {
            if (nums[i] + nums[i + 1] == target) {
                rs++;
            } else {
                break;
            }
        }
        return rs;
    }
}

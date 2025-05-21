package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,-5]
 * 输出：1
 * 解释：第 1 步后，蚂蚁距边界右侧 2 单位远。
 * 第 2 步后，蚂蚁距边界右侧 5 单位远。
 * 第 3 步后，蚂蚁位于边界上。
 * 所以答案是 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,-3,-4]
 * 输出：0
 * 解释：第 1 步后，蚂蚁距边界右侧 3 单位远。
 * 第 2 步后，蚂蚁距边界右侧 5 单位远。
 * 第 3 步后，蚂蚁距边界右侧 2 单位远。
 * 第 4 步后，蚂蚁距边界左侧 2 单位远。
 * 蚂蚁从未返回到边界上，所以答案是 0 。
 */
public class Solution3028 {
    public static void main(String[] args) {
        int[] nums = {2, 3, -5};
        int rs = new Solution3028().returnToBoundaryCount(nums);
        System.out.println("rs = " + rs);
    }

    public int returnToBoundaryCount(int[] nums) {
        int rs = 0;
        int sum = 0;
        for (int num : nums) {
            if (num + sum == 0) {
                rs++;
            }
            sum += num;
        }
        return rs;
    }
}

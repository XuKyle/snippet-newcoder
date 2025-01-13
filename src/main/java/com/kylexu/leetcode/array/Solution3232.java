package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,10]
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * Alice 不管选个位数还是两位数都无法赢得比赛。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5,14]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * Alice 选择个位数可以赢得比赛，所选数字之和为 15。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [5,5,5,25]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * Alice 选择两位数可以赢得比赛，所选数字之和为 25。
 */
public class Solution3232 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 5, 5, 25};
        System.out.println(new Solution3232().canAliceWin(nums));
    }


    public boolean canAliceWin(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;

        for (int num : nums) {
            if (num > 9) {
                sum1 += num;
            } else {
                sum2 += num;
            }
        }

        return sum2 != sum1;
    }
}

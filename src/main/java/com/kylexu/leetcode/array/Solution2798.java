package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：hours = [0,1,2,3,4], target = 2
 * 输出：3
 * 解释：公司要求每位员工工作至少 2 小时。
 * - 员工 0 工作 0 小时，不满足要求。
 * - 员工 1 工作 1 小时，不满足要求。
 * - 员工 2 工作 2 小时，满足要求。
 * - 员工 3 工作 3 小时，满足要求。
 * - 员工 4 工作 4 小时，满足要求。
 * 共有 3 位满足要求的员工。
 * 示例 2：
 * <p>
 * 输入：hours = [5,1,4,2,2], target = 6
 * 输出：0
 * 解释：公司要求每位员工工作至少 6 小时。
 * 共有 0 位满足要求的员工。
 */
public class Solution2798 {
    public static void main(String[] args) {
        int[] hours = new int[]{0, 1, 2, 3, 4};
        int target = 2;
        int rs = new Solution2798().numberOfEmployeesWhoMetTarget(hours, target);
        System.out.println("rs = " + rs);
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int rs = 0;
        for (int hour : hours) {
            if (hour >= target) {
                rs++;
            }
        }
        return rs;
    }
}

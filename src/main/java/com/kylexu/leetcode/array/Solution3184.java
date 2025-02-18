package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入： hours = [12,12,30,24,24]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 构成整天的下标对分别是 (0, 1) 和 (3, 4)。
 * <p>
 * 示例 2：
 * <p>
 * 输入： hours = [72,48,24,3]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。
 */
public class Solution3184 {
    public static void main(String[] args) {
        int[] hours = new int[]{12, 12, 30, 24, 24};
        System.out.println(new Solution3184().countCompleteDayPairs(hours));
    }

    public int countCompleteDayPairs(int[] hours) {
        int rs = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    rs++;
                }
            }
        }
        return rs;
    }
}

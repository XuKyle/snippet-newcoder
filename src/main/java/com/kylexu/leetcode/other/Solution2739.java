package com.kylexu.leetcode.other;

/**
 * 输入：mainTank = 5, additionalTank = 10
 * 输出：60
 * 解释：
 * 在用掉 5 升燃料后，主油箱中燃料还剩下 (5 - 5 + 1) = 1 升，行驶距离为 50km 。
 * 在用掉剩下的 1 升燃料后，没有新的燃料注入到主油箱中，主油箱变为空。
 * 总行驶距离为 60km 。
 * 示例 2：
 * <p>
 * 输入：mainTank = 1, additionalTank = 2
 * 输出：10
 * 解释：
 * 在用掉 1 升燃料后，主油箱变为空。
 * 总行驶距离为 10km 。
 */
public class Solution2739 {
    public static void main(String[] args) {
        int mainTank = 1;
        int additionalTank = 2;
        System.out.println(new Solution2739().distanceTraveled(mainTank, additionalTank));
    }

    public int distanceTraveled(int mainTank, int additionalTank) {
        int cost = 0;

        while (mainTank >= 5 && additionalTank > 0) {
            mainTank = mainTank - 5;
            cost += 5;

            additionalTank--;
            mainTank++;
        }

        if (mainTank >= 0) {
            cost += mainTank;
        }

        return cost * 10;
    }
}

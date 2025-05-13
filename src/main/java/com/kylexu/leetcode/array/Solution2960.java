package com.kylexu.leetcode.array;

public class Solution2960 {
    public static void main(String[] args) {
        int[] batteryPercentages = {0, 1, 2};
        int rs = new Solution2960().countTestedDevices(batteryPercentages);
        System.out.println("rs = " + rs);
    }

    public int countTestedDevices(int[] batteryPercentages) {
        int rs = 0;
        int cost = 0;

        for (int current : batteryPercentages) {
            if (current - cost == 0) {
                continue;
            }

            if (current >= cost) {
                rs++;
                cost++;
            }
        }

        return rs;
    }
}

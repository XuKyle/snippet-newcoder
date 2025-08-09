package com.kylexu.leetcode.array;

public class Solution3633 {
    public static void main(String[] args) {
//        landStartTime = [2,8], landDuration = [4,1], waterStartTime = [6], waterDuration = [3]
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        int i = new Solution3633().earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println("i = " + i);
    }

    /**
     * 一位游客必须从 每个 类别中体验 恰好一个 游乐设施，顺序 不限 。
     * <p>
     * 游乐设施可以在其开放时间开始，或 之后任意时间 开始。
     * 如果一个游乐设施在时间 t 开始，它将在时间 t + duration 结束。
     * 完成一个游乐设施后，游客可以立即乘坐另一个（如果它已经开放），或者等待它开放。
     * 返回游客完成这两个游乐设施的 最早可能时间 。
     *
     * @param landStartTime
     * @param landDuration
     * @param waterStartTime
     * @param waterDuration
     * @return
     */

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int rs = Integer.MAX_VALUE;

        int m = landStartTime.length;
        int n = waterStartTime.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (landStartTime[i] + landDuration[i] >= waterStartTime[j]) {
                    rs = Math.min(rs, landStartTime[i] + landDuration[i] + waterDuration[j]);
                } else {
                    rs = Math.min(rs, waterStartTime[j] + waterDuration[j]);
                }

                if (waterStartTime[j] + waterDuration[j] >= landStartTime[i]) {
                    rs = Math.min(rs, waterStartTime[j] + waterDuration[j] + landDuration[i]);
                } else {
                    rs = Math.min(rs, landStartTime[i] + landDuration[i]);
                }
            }
        }

        return rs;
    }
}

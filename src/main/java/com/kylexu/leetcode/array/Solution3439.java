package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution3439 {
    public static void main(String[] args) {
        int eventTime = 5, k = 1;
        int[] startTime = {1, 3};
        int[] endTime = {2, 5};

        int i = new Solution3439().maxFreeTime(eventTime, k, startTime, endTime);
        System.out.println("i = " + i);
    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> gaps = new ArrayList<>();
        gaps.add(startTime[0]);

        int n = startTime.length;
        for (int i = 1; i < n; i++) {
            gaps.add(startTime[i] - endTime[i - 1]);
        }
        gaps.add(eventTime - endTime[n - 1]);

        int l = 0;
        int acc = 0;
        int rs = 0;

        for (int r = 0; r < gaps.size(); r++) {
            if (r - l <= k) {
                acc += gaps.get(r);
            } else {
                acc += gaps.get(r) - gaps.get(l);
                l++;
            }
            rs = Math.max(rs, acc);
        }

        return rs;
    }
}

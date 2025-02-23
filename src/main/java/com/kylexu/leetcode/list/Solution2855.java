package com.kylexu.leetcode.list;

import java.util.ArrayList;
import java.util.List;

public class Solution2855 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 3, 5);
        System.out.println(new Solution2855().minimumRightShifts(nums));
    }

    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        List<Boolean> mark = new ArrayList<>(nums.size());

        int falseCount = 0;

        for (int i = 0; i < n; i++) {
            boolean flag = nums.get(i) > nums.get((n + i - 1) % n);
            if (!flag) {
                falseCount++;
            }
            mark.add(flag);
        }

        if (falseCount == 0) {
            return 0;
        } else if (falseCount > 1) {
            return -1;
        } else {
            int index = 0;
            for (int i = 0; i < mark.size(); i++) {
                if (!mark.get(i)) {
                    index = i;
                    break;
                }
            }

            if (index == 0) {
                return 0;
            }

            return n - index;
        }
    }
}

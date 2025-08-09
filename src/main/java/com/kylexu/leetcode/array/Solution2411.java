package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution2411 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 3};
        int[] rs = new Solution2411().smallestSubarrays(nums);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] pos = new int[31];
        Arrays.fill(pos, -1);
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            int j = i;
            for (int bit = 0; bit < 31; ++bit) {
                if ((nums[i] & (1 << bit)) == 0) {
                    if (pos[bit] != -1) {
                        j = Math.max(j, pos[bit]);
                    }
                } else {
                    pos[bit] = i;
                }
            }
            ans[i] = j - i + 1;
        }
        return ans;
    }
}

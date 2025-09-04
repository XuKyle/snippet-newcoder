package com.kylexu.leetcode.array;

public class Solution2348 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 0, 2, 0, 0, 4};
        long l = new Solution2348().zeroFilledSubarray(nums);
        System.out.println("l = " + l);
    }

    public long zeroFilledSubarray(int[] nums) {
        var ans = 0L;
        var c = 0;
        for (var num : nums)
            if (num != 0) c = 0;
            else ans += ++c;
        return ans;
    }
}

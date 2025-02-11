package com.kylexu.leetcode.array;

import java.util.List;

//输入： nums = [3, -2, 1, 4], l = 2, r = 3
//
//        输出： 1
//
//        解释：
//
//        长度在 l = 2 和 r = 3 之间且和大于 0 的子数组有：
//
//[3, -2] 和为 1
//                [1, 4] 和为 5
//                [3, -2, 1] 和为 2
//                [-2, 1, 4] 和为 3
//        其中，子数组 [3, -2] 的和为 1，是所有正和中最小的。因此，答案为 1。

//
//示例 2：
//
//输入： nums = [-2, 2, -3, 1], l = 2, r = 3
//
//输出： -1
//
//解释：
//
//不存在长度在 l 和 r 之间且和大于 0 的子数组。因此，答案为 -1。
//
//示例 3：
//
//输入： nums = [1, 2, 3, 4], l = 2, r = 4
//
//输出： 3
//
//解释：
//
//子数组 [1, 2] 的长度为 2，和为 3，是所有正和中最小的。因此，答案为 3。
public class Solution3364 {
    public static void main(String[] args) {
        // todo
        List<Integer> nums = List.of(-3,17);
        int l = 1;
        int r = 2;
        int rs = new Solution3364().minimumSumSubarray(nums, l, r);
        System.out.println("rs = " + rs);
    }

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int rs = Integer.MAX_VALUE;

        for (int i = 0; i <= n - l; i++) {
            int right = i + l;
            int sum = 0;
            for (int j = i; j < right; j++) {
                sum += nums.get(j);
            }

            if (sum > 0) {
                rs = Math.min(rs, sum);
            }
            for (int j = right; j < n && j <= (n - r + l); j++) {
                sum += nums.get(j);
                if (sum > 0) {
                    rs = Math.min(rs, sum);
                }
            }
        }

        return rs == Integer.MAX_VALUE ? -1 : rs;
    }
}

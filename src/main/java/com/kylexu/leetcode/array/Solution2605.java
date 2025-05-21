package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,1,3], nums2 = [5,7]
 * 输出：15
 * 解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
 * 输出：3
 * 解释：数字 3 的数位 3 在两个数组中都出现了。
 */
public class Solution2605 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 3};
        int[] nums2 = {5, 7};
        int rs = new Solution2605().minNumber(nums1, nums2);
        System.out.println("rs = " + rs);
    }

    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int rs : nums1) {
            set.add(rs);
        }

        int rs = Integer.MAX_VALUE;
        for (int i : nums2) {
            if (set.contains(i)) {
                rs = Math.min(i, rs);
            }
        }

        if (rs != Integer.MAX_VALUE) {
            return rs;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (nums1[0] > nums2[0]) {
            return nums2[0] * 10 + nums1[0];
        } else {
            return nums1[0] * 10 + nums2[0];
        }
    }
}

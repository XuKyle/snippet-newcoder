package com.kylexu.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [5,3,6,1,12], original = 3
 * 输出：24
 * 解释：
 * - 3 能在 nums 中找到。3 * 2 = 6 。
 * - 6 能在 nums 中找到。6 * 2 = 12 。
 * - 12 能在 nums 中找到。12 * 2 = 24 。
 * - 24 不能在 nums 中找到。因此，返回 24 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,7,9], original = 4
 * 输出：4
 * 解释：
 * - 4 不能在 nums 中找到。因此，返回 4 。
 */
public class Solution2154 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9};
        int original = 3;
        int finalValue = new Solution2154().findFinalValue(nums, original);
        System.out.println("finalValue = " + finalValue);
    }

    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> mark = new HashSet<>();

        for (int num : nums) {
            mark.add(num);
        }

        while (mark.contains(original)) {
            original = original * 2;
        }

        return original;
    }
}

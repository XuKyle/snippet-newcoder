package com.kylexu.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 *
 * 输出：true
 *
 * 解释：
 *
 * 元素 1 在下标 0 和 3 出现。
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> nSet = new HashSet<>();

        for (int num : nums) {
            if (nSet.contains(num)) {
                return true;
            }
            nSet.add(num);
        }
        return false;
    }
}

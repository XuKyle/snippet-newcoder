package com.kylexu.leetcode.array;

import java.util.*;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的 交集
 * 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class Solution349 {
    public static void main(String[] args) {
        int[] num1 = new int[]{4, 9, 5};
        int[] num2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new Solution349().intersection(num1, num2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        for (int i : nums1) {
            num1Set.add(i);
        }

        Set<Integer> rs = new HashSet<>();
        for (int i : nums2) {
            if (num1Set.contains(i)) {
                rs.add(i);
            }
        }

        return rs.stream().mapToInt(Integer::intValue).toArray();
    }
}

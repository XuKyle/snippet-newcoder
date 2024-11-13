package com.kylexu.leetcode.array;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * 简单
 * 相关标签
 * 相关企业
 * 给你两个整数数组 nums1 和 nums2 ，
 * 请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 */
public class Solution350 {
    public static void main(String[] args) {
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        int[] intersect = new Solution350().intersect(num1, num2);
        System.out.println("intersect = " + Arrays.toString(intersect));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Cnt = new HashMap<>();
        Map<Integer, Integer> nums2Cnt = new HashMap<>();

        for (int i : nums1) {
            nums1Cnt.merge(i, 1, Integer::sum);
        }

        for (int i : nums2) {
            nums2Cnt.merge(i, 1, Integer::sum);
        }

        List<Integer> rs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : nums1Cnt.entrySet()) {
            Integer key = entry.getKey();
            if (nums2Cnt.containsKey(key)) {
                int count = Math.min(entry.getValue(), nums2Cnt.get(key));
                for (int i = 0; i < count; i++) {
                    rs.add(key);
                }
            }
        }

        return rs.stream().mapToInt(Integer::intValue).toArray();
    }
}

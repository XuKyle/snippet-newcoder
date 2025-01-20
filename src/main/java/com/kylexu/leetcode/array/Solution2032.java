package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 示例 1：
 * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出：[3,2]
 * 解释：至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
 * 输出：[2,3,1]
 * 解释：至少在两个数组中出现的所有值为：
 * - 2 ，在数组 nums2 和 nums3 中出现过。
 * - 3 ，在数组 nums1 和 nums2 中出现过。
 * - 1 ，在数组 nums1 和 nums3 中出现过。
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
 * 输出：[]
 * 解释：不存在至少在两个数组中出现的值。
 */
public class Solution2032 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 3};
        int[] nums3 = new int[]{1, 2};
        System.out.println(new Solution2032().twoOutOfThree(nums1, nums2, nums3));
    }


    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = buildSet(nums1);
        Set<Integer> set2 = buildSet(nums2);
        Set<Integer> set3 = buildSet(nums3);

        Set<Integer> allNumbers = new HashSet<>();
        for (int num : nums1) {
            allNumbers.add(num);
        }
        for (int i : nums2) {
            allNumbers.add(i);
        }
        for (int i : nums3) {
            allNumbers.add(i);
        }

        List<Integer> rs = new ArrayList<>();
        for (Integer number : allNumbers) {
            int cnt = 0;
            if (set1.contains(number)) {
                cnt++;
            }
            if (set2.contains(number)) {
                cnt++;
            }
            if (set3.contains(number)) {
                cnt++;
            }
            if (cnt >= 2) {
                rs.add(number);
            }
        }

        return rs;
    }

    private Set<Integer> buildSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }
}

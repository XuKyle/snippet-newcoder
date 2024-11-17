package com.kylexu.leetcode.company.jd;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class Solution4 {
    public static void main(String[] args) {
//        int[] num1 = new int[]{1, 2};
//        int[] num2 = new int[]{3, 4};
//        int[] num1 = new int[]{1, 3};
//        int[] num2 = new int[]{2};

        int[] num1 = new int[]{0, 0};
        int[] num2 = new int[]{0, 0};

        System.out.println(new Solution4().findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLength = nums1.length;
        int bLength = nums2.length;

        int all = aLength + bLength;

        int before = -1;
        int current = -1;

        int aIndex = 0;
        int bIndex = 0;


        for (int i = 0; i <= all / 2; i++) {
            before = current;
            if ((aIndex < aLength && bIndex >= bLength) || (aIndex < aLength && nums1[aIndex] < nums2[bIndex])) {
                current = nums1[aIndex];
                aIndex++;
            } else {
                current = nums2[bIndex];
                bIndex++;
            }
        }

        if (all % 2 == 0) {
            return (before + current) / 2.0;
        } else {
            return current;
        }
    }
}

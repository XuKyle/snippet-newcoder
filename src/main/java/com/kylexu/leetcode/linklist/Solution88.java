package com.kylexu.leetcode.linklist;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */
public class Solution88 {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};

        new Solution88().merge(num1, 3, num2, 3);

        System.out.println("num1 = " + Arrays.toString(num1));
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        for (int index = k - 1, num1Index = m - 1, num2Index = n - 1; index >= 0; index--) {
            if (num1Index < 0) {
                nums1[index] = nums2[num2Index];
                num2Index--;
            } else if (num2Index < 0) {
                break;
            } else if (nums1[num1Index] > nums2[num2Index]) {
                nums1[index] = nums1[num1Index];
                num1Index--;
            } else {
                nums1[index] = nums2[num2Index];
                num2Index--;
            }
        }
    }
}

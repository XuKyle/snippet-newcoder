package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class Solution128 {
    public static void main(String[] args) {
//        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
//        int[] nums = new int[]{0, 0};
        int longested = new Solution128().longestConsecutive(nums);
        System.out.println("longested = " + longested);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // 假设重复的那个元素就是最终答案的起点复杂度可能会大于O(n)。
        // 可以想象一下这样的nums数组，共100个元素，前50个是1，后五十个元素是从2到51。while循环会跑50*50次，大于遍历去重的最坏情况。个人的一些思考，仅供参考。
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

package com.kylexu.leetcode.array;

/**
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 * 示例：
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 */
public class Solution1287 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(new Solution1287().findSpecialInteger(arr));
    }

    public int findSpecialInteger(int[] arr) {
        int n = arr.length / 4;

        int left = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[left]) {
                if (i - left > n) {
                    return arr[left];
                }
                left = i;
            }
        }

        return arr[left];
    }
}

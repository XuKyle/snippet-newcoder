package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个长度固定的整数数组 arr ，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,0,2,3,0,4,5,0]
 * 输出：[1,0,0,2,3,0,0,4]
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 */
public class Solution1089 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        new Solution1089().duplicateZeros(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0 && i != n - 1) {
                for (int j = n - 2; j > i; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[i + 1] = arr[i];
                i++;
            }
        }
    }
}

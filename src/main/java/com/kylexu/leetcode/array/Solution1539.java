package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 */
public class Solution1539 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(new Solution1539().findKthPositive(arr, k));
    }

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        int lost = 0;
        int i = 1;
        int j = 0;
        while (lost < k) {
            if (j < n && arr[j] == i) {
                i++;
                j++;
            } else {
                lost++;
                if (lost == k) {
                    return i;
                }
                i++;
            }
        }
        return i;
    }
}

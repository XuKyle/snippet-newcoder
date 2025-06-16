package com.kylexu.leetcode.array;

/**
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 */
public class Solution1588 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 11, 12};
        System.out.println(new Solution1588().sumOddLengthSubarrays(arr));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int rs = 0;

        int n = arr.length;

        // i = 子串的长度
        for (int i = 1; i < n + 1; i += 2) {
            for (int j = 0; j < n && j + i - 1 < n; j++) {
                for (int k = j; k < j + i; k++) {
                    rs += arr[k];
                }
            }
        }

        return rs;
    }
}

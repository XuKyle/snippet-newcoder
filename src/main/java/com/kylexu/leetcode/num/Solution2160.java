package com.kylexu.leetcode.num;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：num = 2932
 * 输出：52
 * 解释：可行的 [new1, new2] 数对为 [29, 23] ，[223, 9] 等等。
 * 最小和为数对 [29, 23] 的和：29 + 23 = 52 。
 * 示例 2：
 * <p>
 * 输入：num = 4009
 * 输出：13
 * 解释：可行的 [new1, new2] 数对为 [0, 49] ，[490, 0] 等等。
 * 最小和为数对 [4, 9] 的和：4 + 9 = 13 。
 */
public class Solution2160 {
    public static void main(String[] args) {
        int num = 2932;
        System.out.println(new Solution2160().minimumSum(num));
    }

    public int minimumSum(int num) {
        int[] arr = new int[4];

        for (int i = 0; i < 4; i++) {
            arr[i] = num % 10;
            num = num / 10;
        }

        Arrays.sort(arr);

        int rs = 0;
        for (int i = 0; i < 4; i++) {
            if (i < 2) {
                rs += arr[i] * 10;
            } else {
                rs += arr[i];
            }
        }
        return rs;
    }
}

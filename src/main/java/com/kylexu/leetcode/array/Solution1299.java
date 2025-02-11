package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 * 解释：
 * - 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
 * - 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
 * - 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
 * 示例 2：
 * <p>
 * 输入：arr = [400]
 * 输出：[-1]
 * 解释：下标 0 的元素右侧没有其他元素。
 */
public class Solution1299 {
    public static void main(String[] args) {
        int[] arr = new int[]{400};
        int[] rs = new Solution1299().replaceElements(arr);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] replaceElements(int[] arr) {
        int[] rs = new int[arr.length];

        int max = Integer.MIN_VALUE;

        rs[rs.length - 1] = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            max = Math.max(current, max);

            if (i > 0) {
                rs[i - 1] = max;
            }
        }

        return rs;
    }
}

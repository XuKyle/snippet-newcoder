package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 示例 1：
 * <p>
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 * 示例 2：
 * <p>
 * 输入：arr = [100,100,100]
 * 输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 * 示例 3：
 * <p>
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 */
public class Solution1331 {
    public static void main(String[] args) {
        int[] arr = new int[]{40, 10, 20, 30};
        int[] rs = new Solution1331().arrayRankTransform(arr);
        System.out.println(Arrays.toString(rs));
    }

    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        Map<Integer, Integer> index = new HashMap<>();
        int before = copy[0];
        int rank = 1;
        index.put(before, rank);

        for (int i = 1; i < copy.length; i++) {
            if (copy[i] == before) {
                continue;
            }

            rank++;
            index.put(copy[i], rank);
            before = copy[i];
        }

        int[] rs = new int[arr.length];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = index.get(arr[i]);
        }

        return rs;
    }
}

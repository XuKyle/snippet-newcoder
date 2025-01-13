package com.kylexu.leetcode.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * 每对元素对 [a,b] 如下：
 * <p>
 * a , b 均为数组 arr 中的元素
 * a < b
 * b - a 等于 arr 中任意两个元素的最小绝对差
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 */
public class Solution1200 {
    public static void main(String[] args) {
//        int[] arr = new int[]{3, 8, -10, 23, 19, -4, -14, 27};
        int[] arr = new int[]{1, 3, 6, 10, 15};
        List<List<Integer>> rs = new Solution1200().minimumAbsDifference(arr);

        System.out.println("rs = " + rs);
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int[] gap = new int[arr.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int tmp = arr[i + 1] - arr[i];
            min = Math.min(tmp, min);
            gap[i] = tmp;
        }

        List<List<Integer>> rs = new ArrayList<>();
        for (int i = 0; i < gap.length; i++) {
            if (gap[i] == min) {
                rs.add(List.of(arr[i], arr[i + 1]));
            }
        }

        return rs;
    }
}

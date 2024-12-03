package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 示例 1：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * 示例  2:
 * <p>
 * 输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * 输出：[22,28,8,6,17,44]
 */
public class Solution1122 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(new Solution1122().relativeSortArray(arr1, arr2)));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr2.length;
        Map<Integer, Integer> mark = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            mark.put(arr2[i], i);
        }

        Stream<Integer> sorted = Arrays.stream(arr1).boxed()
                .sorted((o1, o2) -> {
                    Integer left = mark.get(o1);
                    Integer right = mark.get(o2);
                    if (left == null) {
                        left = n + o1;
                    }
                    if (right == null) {
                        right = n + o2;
                    }
                    return Integer.compare(left, right);
                });

        return sorted.mapToInt(Integer::intValue).toArray();
    }
}

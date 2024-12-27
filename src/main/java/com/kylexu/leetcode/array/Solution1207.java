package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 arr，如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 */
public class Solution1207 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        System.out.println(new Solution1207().uniqueOccurrences(arr));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Long> numCount = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new HashSet<>(numCount.values()).size() == numCount.size();
    }
}

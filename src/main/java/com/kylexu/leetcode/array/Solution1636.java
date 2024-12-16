package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1636. 按照频率将数组升序排序
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 */
public class Solution1636 {
    public int[] frequencySort(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<Integer, Long>comparingByValue().thenComparing((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                )
                .flatMapToInt(e -> IntStream.generate(e::getKey).limit(e.getValue()))
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(new Solution1636().frequencySort(nums)));
    }
}

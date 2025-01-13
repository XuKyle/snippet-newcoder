package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给你一个由 正整数 组成的数组 nums 。
 * 返回数组 nums 中所有具有 最大 频率的元素的 总频率 。
 * 元素的 频率 是指该元素在数组中出现的次数。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,3,1,4]
 * 输出：4
 * 解释：元素 1 和 2 的频率为 2 ，是数组中的最大频率。
 * 因此具有最大频率的元素在数组中的数量是 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：5
 * 解释：数组中的所有元素的频率都为 1 ，是最大频率。
 * 因此具有最大频率的元素在数组中的数量是 5 。
 */
public class Solution3005 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(new Solution3005().maxFrequencyElements(nums));
    }

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Long> mark = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        long max = 0;
        for (Map.Entry<Integer, Long> entry : mark.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        int rs = 0;
        for (Map.Entry<Integer, Long> entry : mark.entrySet()) {
            if (entry.getValue() == max) {
                rs += (int) max;
            }
        }

        return rs;
    }
}

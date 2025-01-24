package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入：nums = [1,2,2,3,1]
 * 输出：2
 * 解释：
 * 输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
 * 连续子数组里面拥有相同度的有如下所示：
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,2,3,1,4,2]
 * 输出：6
 * 解释：
 * 数组的度是 3 ，因为元素 2 重复出现 3 次。
 * 所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
 */
public class Solution697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }

        Map<Integer, List<Integer>> counterToList = new HashMap<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer value = entry.getValue();
            max = Math.max(max, value);
            counterToList.computeIfAbsent(value, k -> new ArrayList<>()).add(entry.getKey());
        }


        int min = Integer.MAX_VALUE;
        for (Integer num : counterToList.get(max)) {
            int start = 0;
            while (nums[start] != num) {
                start++;
            }

            int end = nums.length - 1;
            while (nums[end] != num) {
                end--;
            }
            min = Math.min(min, end - start + 1);
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
        System.out.println(new Solution697().findShortestSubArray(nums));
    }
}


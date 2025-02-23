package com.kylexu.leetcode.array;

import java.util.*;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3,3], k = 2
 * 输出：[3,3]
 * 解释：
 * 子序列有最大和：3 + 3 = 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,-2,3,4], k = 3
 * 输出：[-1,3,4]
 * 解释：
 * 子序列有最大和：-1 + 3 + 4 = 6 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,4,3,3], k = 2
 * 输出：[3,4]
 * 解释：
 * 子序列有最大和：3 + 4 = 7 。
 * 另一个可行的子序列为 [4, 3] 。
 */
public class Solution2099 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 3, 3};
        int k = 2;
        int[] rs = new Solution2099().maxSubsequence(nums, k);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] maxSubsequence(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        return map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(k)
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .mapToInt(Map.Entry::getValue)
                .toArray();
    }
}

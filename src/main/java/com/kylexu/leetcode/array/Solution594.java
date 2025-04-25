package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 最长和谐子序列是 [3,2,2,2,3]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 最长和谐子序列是 [1,2]，[2,3] 和 [3,4]，长度都为 2。
 */
public class Solution594 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(new Solution594().findLHS(nums));
    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }

        if (counter.size() == 1) {
            return 0;
        }

        int rs = 0;

        for (int num : nums) {
            if (counter.containsKey(num) && counter.containsKey(num + 1)) {
                rs = Math.max(rs, counter.get(num) + counter.get(num + 1));
            }
        }

        return rs;
    }
}

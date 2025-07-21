package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,2,1], queries = [3,10,21]
 * 输出：[2,3,4]
 * 解释：queries 对应的 answer 如下：
 * - 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
 * - 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
 * - 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
 */
public class Solution2398 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        int[] rs = new Solution2398().answerQueries(nums, queries);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] rs = new int[queries.length];

        Arrays.sort(nums);
        
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (sum + nums[j] <= query) {
                    rs[i] = j + 1;
                }
                sum += nums[j];
            }
        }

        return rs;
    }
}

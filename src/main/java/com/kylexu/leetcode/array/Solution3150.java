package com.kylexu.leetcode.array;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,3,3,2]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * nums 中严格递增的子数组有[1]、[2]、[3]、[3]、[4] 以及 [1,4] 。
 * <p>
 * nums 中严格递减的子数组有[1]、[2]、[3]、[3]、[4]、[3,2] 以及 [4,3] 。
 * <p>
 * 因此，返回 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,3,3,3]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 中严格递增的子数组有 [3]、[3]、[3] 以及 [3] 。
 * <p>
 * nums 中严格递减的子数组有 [3]、[3]、[3] 以及 [3] 。
 * <p>
 * 因此，返回 1 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * nums 中严格递增的子数组有 [3]、[2] 以及 [1] 。
 * <p>
 * nums 中严格递减的子数组有 [3]、[2]、[1]、[3,2]、[2,1] 以及 [3,2,1] 。
 * <p>
 * 因此，返回 3 。
 */
public class Solution3150 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3};
        int rs = new Solution3150().longestMonotonicSubarray(nums);
        System.out.println("rs = " + rs);
    }

    public int longestMonotonicSubarray(int[] nums) {
        int rs = 0;

        int n = nums.length;
        // 升序
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                mark[i] = -1;
            } else {
                mark[i] = nums[i] - nums[i - 1];
            }
        }
//        System.out.println("mark = " + Arrays.toString(mark));

        int start = 0;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] > 0) {
                rs = Math.max(i - start + 1, rs);
            } else {
                start = i;
            }
        }

        start = 0;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] < 0) {
                rs = Math.max(i - start + 1, rs);
            } else {
                start = i;
            }
        }

        return rs;
    }
}

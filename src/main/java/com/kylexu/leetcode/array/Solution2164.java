package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 按 非递增 顺序排列 nums 奇数下标 上的所有值。
 * 按 非递减 顺序排列 nums 偶数下标 上的所有值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,2,3]
 * 输出：[2,3,4,1]
 * 解释：
 * 首先，按非递增顺序重排奇数下标（1 和 3）的值。
 * 所以，nums 从 [4,1,2,3] 变为 [4,3,2,1] 。
 * 然后，按非递减顺序重排偶数下标（0 和 2）的值。
 * 所以，nums 从 [4,1,2,3] 变为 [2,3,4,1] 。
 * 因此，重排之后形成的数组是 [2,3,4,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,1]
 * 输出：[2,1]
 * 解释：
 * 由于只有一个奇数下标和一个偶数下标，所以不会发生重排。
 * 形成的结果数组是 [2,1] ，和初始数组一样。
 */
public class Solution2164 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 3, 1};
        int[] rs = new Solution2164().sortEvenOdd(nums);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] sortEvenOdd(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }

        int[] rs = new int[nums.length];

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                odd.add(nums[i]);
            } else {
                even.add(nums[i]);
            }
        }
        odd.sort(Comparator.naturalOrder());
        even.sort(Comparator.reverseOrder());

        int n = Math.max(odd.size(), even.size());
        for (int i = 0; i < n; i++) {
            rs[i * 2] = odd.get(i);
            if (i * 2 + 1 < nums.length) {
                rs[i * 2 + 1] = even.get(i);
            }
        }

        return rs;
    }
}


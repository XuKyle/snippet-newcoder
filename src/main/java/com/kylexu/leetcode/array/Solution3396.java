package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums，你需要确保数组中的元素 互不相同 。为此，你可以执行以下操作任意次：
 * 从数组的开头移除 3 个元素。如果数组中元素少于 3 个，则移除所有剩余元素。
 * 注意：空数组也视作为数组元素互不相同。返回使数组元素互不相同所需的 最少操作次数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3,4,2,3,3,5,7]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 第一次操作：移除前 3 个元素，数组变为 [4, 2, 3, 3, 5, 7]。
 * 第二次操作：再次移除前 3 个元素，数组变为 [3, 5, 7]，此时数组中的元素互不相同。
 * 因此，答案是 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [4,5,6,4,4]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 第一次操作：移除前 3 个元素，数组变为 [4, 4]。
 * 第二次操作：移除所有剩余元素，数组变为空。
 * 因此，答案是 2。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [6,7,8,9]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组中的元素已经互不相同，因此不需要进行任何操作，答案是 0。
 */
public class Solution3396 {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 7, 8, 9};
        System.out.println(new Solution3396().minimumOperations(nums));
    }


    public int minimumOperations(int[] nums) {
        int rs = 0;

        while (containSame(nums)) {
            if (nums.length <= 3) {
                return rs + 1;
            } else {
                nums = Arrays.copyOfRange(nums, 3, nums.length);
                rs++;
            }
        }

        return rs;
    }

    public boolean containSame(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> buck = new HashSet<>();

        for (int num : nums) {
            if (buck.contains(num)) {
                return true;
            }
            buck.add(num);
        }
        return false;
    }
}

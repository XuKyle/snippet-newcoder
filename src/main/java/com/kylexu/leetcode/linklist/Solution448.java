package com.kylexu.leetcode.linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 */
public class Solution448 {
    public static void main(String[] args) {
        int[] ints = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = new Solution448().findDisappearedNumbers(ints);

        System.out.println("disappearedNumbers = " + disappearedNumbers);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currentIndex = Math.abs(nums[i]) - 1;

            if (nums[currentIndex] > 0) {
                nums[currentIndex] = nums[currentIndex] * -1;
            }
        }

        List<Integer> rs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                rs.add(i + 1);
            }
        }
        return rs;
    }
}

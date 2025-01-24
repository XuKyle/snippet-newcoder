package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,4,6,7,10], diff = 3
 * 输出：2
 * 解释：
 * (1, 2, 4) 是等差三元组：7 - 4 == 3 且 4 - 1 == 3 。
 * (2, 4, 5) 是等差三元组：10 - 7 == 3 且 7 - 4 == 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,8,9], diff = 2
 * 输出：2
 * 解释：
 * (0, 2, 4) 是等差三元组：8 - 6 == 2 且 6 - 4 == 2 。
 * (1, 3, 5) 是等差三元组：9 - 7 == 2 且 7 - 5 == 2 。
 */
public class Solution2367 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 8, 9};
        int diff = 2;
        System.out.println(new Solution2367().arithmeticTriplets(nums, diff));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int rs = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + diff < nums[j]) {
                    break;
                }
                if (nums[i] + diff != nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] + diff == nums[k]) {
                        rs++;
                    }
                }
            }
        }
        return rs;
    }
}

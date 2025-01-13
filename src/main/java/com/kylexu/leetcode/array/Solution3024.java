package com.kylexu.leetcode.array;

/**
 * 示例 1：
 * 输入：nums = [3,3,3]
 * 输出："equilateral"
 * 解释：由于三条边长度相等，所以可以构成一个等边三角形，返回 "equilateral" 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5]
 * 输出："scalene"
 * 解释：
 * nums[0] + nums[1] = 3 + 4 = 7 ，大于 nums[2] = 5 。
 * nums[0] + nums[2] = 3 + 5 = 8 ，大于 nums[1] = 4 。
 * nums[1] + nums[2] = 4 + 5 = 9 ，大于 nums[0] = 3 。
 * 由于任意两边之和都大于第三边，所以可以构成一个三角形，因为三条边的长度互不相等，所以返回 "scalene"。
 */
public class Solution3024 {
    public static void main(String[] args) {
//        如果一个三角形的所有边长度相等，那么这个三角形称为 equilateral 。
//        如果一个三角形恰好有两条边长度相等，那么这个三角形称为 isosceles 。
//        如果一个三角形三条边的长度互不相同，那么这个三角形称为 scalene 。

        int[] nums = new int[]{3, 4, 5};
        System.out.println(new Solution3024().triangleType(nums));

    }

    public String triangleType(int[] nums) {
        int max = Math.max(Math.max(nums[0], nums[1]), nums[2]);

        if (2 * max >= nums[0] + nums[1] + nums[2]) {
            return "none";
        }

        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }

        if (nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2]) {
            return "scalene";
        }

        return "isosceles";
    }
}

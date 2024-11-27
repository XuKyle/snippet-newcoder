package com.kylexu.leetcode.array;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,2]
 * 输出：5
 * 解释：你可以用三个边长组成一个三角形:1 2 2。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,10]
 * 输出：0
 * 解释：
 * 你不能用边长 1,1,2 来组成三角形。
 * 不能用边长 1,1,10 来构成三角形。
 * 不能用边长 1、2 和 10 来构成三角形。
 * 因为我们不能用任何三条边长来构成一个非零面积的三角形，所以我们返回 0。
 */
public class Solution976 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new Solution976().largestPerimeter(nums));
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        return 0;
    }


    public int largestPerimeter1(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (canBeTriangle(nums[i], nums[j], nums[k])) {
                        return nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }

        return 0;
    }

    private boolean canBeTriangle(int a, int b, int c) {
        /**
         * 判断三边能否构成三角形的条件有两条：
         * <p>
         * 1、三角形两边之和大于第三边：任意两边的长度之和要大于第三边的长度，即a+b>c（a、b、c为三角形的三条边）。
         * 2、三角形两边之差小于第三边：任意两边的长度之差要小于第三边的长度，即|a-b|<c。
         */

        /**
         * 三角形三边和定理 只要最小两边和大于第三边就可以构成三角形
         */
        if (a + b > c && a + c > b && b + c > a) {

        } else {
            return false;
        }

        if (Math.abs(a - b) < c && Math.abs(a - c) < b && Math.abs(b - c) < a) {

        } else {
            return false;
        }

        return true;
    }
}

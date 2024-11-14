package com.kylexu.leetcode.array;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class Solution11 {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = new int[]{1, 1};
        System.out.println(new Solution11().maxArea(height));
    }

    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int an = 0;

        while (leftIndex < rightIndex) {
            int left = height[leftIndex];
            int right = height[rightIndex];

            an = Math.max(an, (rightIndex - leftIndex) * Math.min(left, right));

            if (left <= right) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return an;
    }

    public int maxArea1(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int wi = j - i;
                int hi = Math.min(height[i], height[j]);
                max = Math.max(wi * hi, max);
            }
        }

        return max;
    }
}

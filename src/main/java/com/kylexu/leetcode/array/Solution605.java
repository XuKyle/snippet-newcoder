package com.kylexu.leetcode.array;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，
 * 其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 */
public class Solution605 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 0, 0, 1};
        System.out.println(new Solution605().canPlaceFlowers(nums, 1));

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 拼接一下
        int[] f = new int[flowerbed.length + 2];
        f[0] = 0;
        f[f.length - 1] = 0;
        System.arraycopy(flowerbed, 0, f, 1, flowerbed.length);

        int count = 0;
        for (int i = 1; i < f.length - 1; i++) {
            int pre = f[i - 1];
            int now = f[i];
            int next = f[i + 1];

            if (pre + now + next == 0) {
                f[i] = 1;
                count++;
            }


        }
        return count >= n;
    }
}
package com.kylexu.leetcode.other;

/**
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * 示例 2：
 * <p>
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 */
public class Solution1523 {
    public static void main(String[] args) {
        System.out.println(new Solution1523().countOdds(3, 7));
    }

    public int countOdds(int low, int high) {
        boolean lowFlag = low % 2 == 0;
        boolean highFlag = high % 2 == 0;

        if (!lowFlag) {
            low++;
        }
        if (!highFlag) {
            high--;
        }

        int rs = (high - low) / 2;
        if (!lowFlag) {
            rs++;
        }
        if (!highFlag) {
            rs++;
        }
        return rs;
    }

//    public int countOdds(int low, int high) {
//        int count = 0;
//
//        for (int i = low; i <= high; i++) {
//            if (i % 2 == 1) {
//                count++;
//            }
//        }
//
//        return count;
//    }
}

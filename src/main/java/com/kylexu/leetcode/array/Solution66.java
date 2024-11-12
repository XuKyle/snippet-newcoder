package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution66 {
    public static void main(String[] args) {
//        输入：digits = [1,2,3]
//        输出：[1,2,4]
//        解释：输入数组表示数字 123。
//
//        输入：digits = [9]
//        输出：[1,0]
//        解释：输入数组表示数字 9。
//        加 1 得到了 9 + 1 = 10。
//        因此，结果应该是 [1,0]。

        int[] a = {1, 2, 3};
        int[] ints = new Solution66().plusOne(a);
        System.out.println("ints = " + Arrays.toString(ints));

        int[] b = {9, 9, 9};
        int[] rs = new Solution66().plusOne(b);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public int[] plusOne(int[] digits) {
        int carrier = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carrier;
            if (i == digits.length - 1) {
                num += 1;
            }

            carrier = num / 10;
            digits[i] = num % 10;
        }

        if (carrier == 1) {
            int[] rs = new int[digits.length + 1];
            System.arraycopy(digits, 0, rs, 1, digits.length);
            rs[0] = carrier;
            return rs;
        }
        return digits;
    }
}

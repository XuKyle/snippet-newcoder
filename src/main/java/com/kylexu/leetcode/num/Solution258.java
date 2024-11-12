package com.kylexu.leetcode.num;

public class Solution258 {
    public int addDigits(int num) {
        int rs = 0;
        while (num > 0) {
            rs += num % 10;
            num /= 10;
        }

        if (rs < 10) {
            return rs;
        } else {
            return addDigits(rs);
        }
    }

    public static void main(String[] args) {
//        输入: num = 38
//        输出: 2

        System.out.println(new Solution258().addDigits(38));
    }
}

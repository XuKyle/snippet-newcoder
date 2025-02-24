package com.kylexu.leetcode.num;

public class Solution2169 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;
        System.out.println(new Solution2169().countOperations(num1, num2));
    }

    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }

        if (num1 > num2) {
            return 1 + countOperations(num1 - num2, num2);
        } else {
            return 1 + countOperations(num2 - num1, num1);
        }
    }
}

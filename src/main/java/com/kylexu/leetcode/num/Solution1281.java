package com.kylexu.leetcode.num;

public class Solution1281 {
    public static void main(String[] args) {
        int n = 4421;
        System.out.println(new Solution1281().subtractProductAndSum(n));
    }

    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        while (n != 0) {
            int left = n % 10;
            product *= left;
            sum += left;
            n = n / 10;
        }


        return product - sum;
    }
}

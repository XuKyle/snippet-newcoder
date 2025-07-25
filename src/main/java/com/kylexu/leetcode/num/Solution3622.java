package com.kylexu.leetcode.num;

import java.util.ArrayList;
import java.util.List;

public class Solution3622 {
    public static void main(String[] args) {
        int n = 99;
        boolean b = new Solution3622().checkDivisibility(n);
        System.out.println("b = " + b);
    }

    public boolean checkDivisibility(int n) {
        int newValue = partProduct(n) + partSum(n);
        return n % newValue == 0;
    }

    private Integer partSum(int n) {
        int rs = 0;

        while (n != 0) {
            rs += n % 10;
            n = n / 10;
        }

        return rs;
    }

    private Integer partProduct(int n) {
        int rs = 1;

        while (n != 0) {
            rs *= n % 10;
            n = n / 10;
        }

        return rs;
    }

}

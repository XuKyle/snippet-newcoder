package com.kylexu.leetcode.num;

public class Solution2591 {
    public static void main(String[] args) {
        int money = 20;
        int children = 3;
        int rs = new Solution2591().distMoney(money, children);
        System.out.println("rs = " + rs);
    }

    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }

        int temp = children * 8 - money;
        if (temp == 4) {
            return children - 2;
        }
        if (temp < 0) {
            return children - 1;
        }

        return (money - children) / 7;
    }
}

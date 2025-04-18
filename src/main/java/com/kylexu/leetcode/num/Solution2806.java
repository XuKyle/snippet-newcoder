package com.kylexu.leetcode.num;

/**
 * 一开始，你的银行账户里有 100 块钱。
 * <p>
 * 给你一个整数purchaseAmount ，它表示你在一次购买中愿意支出的金额。
 * <p>
 * 在一个商店里，你进行一次购买，实际支出的金额会向 最近 的 10 的 倍数 取整。换句话说，
 * 你实际会支付一个 非负 金额 roundedAmount ，满足 roundedAmount 是 10 的倍数  且 abs(roundedAmount - purchaseAmount) 的值 最小 。
 * <p>
 * 如果存在多于一个最接近的 10 的倍数，较大的倍数 是你的实际支出金额。
 * <p>
 * 请你返回一个整数，表示你在愿意支出金额为 purchaseAmount 块钱的前提下，购买之后剩下的余额。
 * <p>
 * 注意： 0 也是 10 的倍数。
 */
public class Solution2806 {
    public static void main(String[] args) {
        int purchaseAmount = 15;
        int i = new Solution2806().accountBalanceAfterPurchase(purchaseAmount);
        System.out.println("i = " + i);
    }

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int left = purchaseAmount % 10;
        int ten = purchaseAmount / 10;

        int rs = 0;
        if (left < 5) {
            rs = ten * 10;
        } else {
            rs = (ten + 1) * 10;
        }
        return 100 - rs;
    }
}

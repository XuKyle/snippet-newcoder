package com.kylexu.leetcode.recursion;

import java.math.BigInteger;

public class LCRSolution126 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        BigInteger[] memo = new BigInteger[n + 1];
        memo[0] = BigInteger.valueOf(0);
        memo[1] = BigInteger.valueOf(1);

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1].add(memo[i - 2]);
        }
        BigInteger mod = memo[n].mod(BigInteger.valueOf(1000000007));
        return mod.intValue();
    }

    public static void main(String[] args) {
//        答案需要取模 1e9+7(1000000007) ，如计算初始结果为：1000000008，请返回 1。
        System.out.println(new LCRSolution126().fib(5));
    }
}


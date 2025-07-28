package com.kylexu.leetcode.num;

import java.util.HashSet;
import java.util.Set;

public class Solution762 {
    public static void main(String[] args) {
        int left = 6, right = 10;
        int i = new Solution762().countPrimeSetBits(left, right);
        System.out.println("i = " + i);
    }

    public int countPrimeSetBits(int left, int right) {
        int rs = 0;

        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                rs++;
            }
        }

        return rs;
    }

    Set<Integer> primes = new HashSet<>();

    private boolean isPrime(int count) {
        if (count == 1) {
            return false;
        }
        if (primes.contains(count)) {
            return true;
        }

        for (int i = 2; i < count; i++) {
            if (count % i == 0) {
                return false;
            }
        }
        primes.add(count);
        return true;
    }
}

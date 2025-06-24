package com.kylexu.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3591 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 4};
        boolean rs = new Solution3591().checkPrimeFrequency(nums);
        System.out.println("rs = " + rs);
    }

    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> sum = new HashMap<>();

        for (int num : nums) {
            sum.merge(num, 1, Integer::sum);
        }
        Set<Integer> counters = new HashSet<>(sum.values());

        for (Integer counter : counters) {
            if (isPrime(counter)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPrime(Integer counter) {
        if (counter <= 1) return false;
        for (int i = 2; i <= Math.sqrt(counter); i++) {
            if (counter % i == 0) return false;
        }
        return true;
    }
}

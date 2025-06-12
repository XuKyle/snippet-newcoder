package com.kylexu.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class Solution3483 {
    public static void main(String[] args) {
        int[] digit = {6, 6, 6};
        int rs = new Solution3483().totalNumbers(digit);
        System.out.println("rs = " + rs);
    }

    public int totalNumbers(int[] digits) {
        Set<Integer> rs = new HashSet<>();

        int n = digits.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    if (digits[i] == 0) {
                        continue;
                    }

                    if (digits[j] % 2 == 0) {
                        rs.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                    }
                }
            }
        }

        return rs.size();
    }
}

package com.kylexu.leetcode.num;

public class Solution2269 {
    public static void main(String[] args) {
        int num = 2;
        int k = 1;
        System.out.println(new Solution2269().divisorSubstrings(num, k));
    }

    public int divisorSubstrings(int num, int k) {
        int rs = 0;

        String numStr = String.valueOf(num);

        if (numStr.length() == k) {
            return 1;
        }

        for (int i = 0; i < numStr.length() - k + 1; i++) {
            int parsed = Integer.parseInt(numStr.substring(i, i + k));
            if (parsed == 0) {
                continue;
            }

            if (num % parsed == 0) {
                rs++;
            }
        }

        return rs;
    }
}

package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3333 {
    public static void main(String[] args) {
        String word = "aaabbb";
        int k = 3;
        int count = new Solution3333().possibleStringCount(word, k);
        System.out.println("count = " + count);
    }

    private static final int mod = 1000000007;


    public int possibleStringCount(String word, int k) {
        List<Integer> freq = new ArrayList<>();

        int left = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(left)) {
                freq.add(i - left);
                left = i;
            }

            if (i == word.length() - 1) {
                freq.add(i - left + 1);
            }
        }

        long ans = 1;
        for (int o : freq) {
            ans = ans * o % mod;
        }
        if (freq.size() >= k) {
            return (int) ans;
        }

        int[] f = new int[k];
        int[] g = new int[k];
        f[0] = 1;
        Arrays.fill(g, 1);
        for (int i = 0; i < freq.size(); ++i) {
            int[] f_new = new int[k];
            for (int j = 1; j < k; ++j) {
                f_new[j] = g[j - 1];
                if (j - freq.get(i) - 1 >= 0) {
                    f_new[j] = (f_new[j] - g[j - freq.get(i) - 1] + mod) % mod;
                }
            }
            int[] g_new = new int[k];
            g_new[0] = f_new[0];
            for (int j = 1; j < k; ++j) {
                g_new[j] = (g_new[j - 1] + f_new[j]) % mod;
            }
            f = f_new;
            g = g_new;
        }

        return (int) ((ans - g[k - 1] + mod) % mod);
    }
}

package com.kylexu.leetcode.str;

public class Solution3456 {
    public static void main(String[] args) {
        String s = "abc";
        int k = 2;
        System.out.println(new Solution3456().hasSpecialSubstring(s, k));
    }

    public boolean hasSpecialSubstring(String s, int k) {
        // todo
        if (k == 1) {
            return true;
        }

        int n = s.length();
        int left = 0;

        while (left < n - k) {
            char leftSource = s.charAt(left);

            for (int i = left + 1; i < left + k; i++) {
                if (s.charAt(i) != leftSource) {
                    break;
                } else {
                    if (i == left + k - 1) {
                        return true;
                    }
                }
            }
            left++;
        }

        return false;
    }
}

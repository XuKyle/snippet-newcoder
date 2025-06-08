package com.kylexu.leetcode.array;

public class Solution2511 {
    public static void main(String[] args) {
        int[] forts = {1, 0, 0, -1};
        int i = new Solution2511().captureForts(forts);
        System.out.println("i = " + i);
    }

    public int captureForts(int[] forts) {
        int rs = 0;

        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                int j = i - 1;
                while (j >= 0 && forts[j] == 0) {
                    j--;
                }
                if (j > -1 && forts[j] == -1) {
                    rs = Math.max(rs, i - j - 1);
                }

                int k = i + 1;
                while (k < forts.length && forts[k] == 0) {
                    k++;
                }
                if (k <= forts.length - 1 && forts[k] == -1) {
                    rs = Math.max(rs, k - i - 1);
                }
            }
        }

        return rs;
    }
}

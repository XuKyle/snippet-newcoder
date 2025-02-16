package com.kylexu.leetcode.array;

public class Solution2073 {
    public static void main(String[] args) {
        int[] tickets = new int[]{2, 3, 2};
        int k = 2;
        System.out.println(new Solution2073().timeRequiredToBuy(tickets, k));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int rs = 0;

        int atLeast = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                rs += Math.min(atLeast, tickets[i]);
            } else {
                rs += Math.min(atLeast - 1, tickets[i]);
            }
        }

        return rs;
    }
}

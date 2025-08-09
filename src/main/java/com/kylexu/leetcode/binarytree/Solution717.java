package com.kylexu.leetcode.binarytree;

public class Solution717 {
    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        boolean oneBitCharacter = new Solution717().isOneBitCharacter(bits);
        System.out.println("oneBitCharacter = " + oneBitCharacter);
    }

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            i += bits[i] + 1;
        }
        return i == n - 1;
    }
}

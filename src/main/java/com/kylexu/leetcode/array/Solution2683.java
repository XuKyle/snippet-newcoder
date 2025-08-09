package com.kylexu.leetcode.array;

public class Solution2683 {
    public static void main(String[] args) {
        int[] derived = {1, 1, 0};
        boolean b = new Solution2683().doesValidArrayExist(derived);
        System.out.println("b = " + b);
    }

    public boolean doesValidArrayExist(int[] derived) {
        int rs = 0;
        for (int i : derived) {
            if (i == 1) {
                rs++;
            }
        }
        return rs % 2 == 0;
    }
}

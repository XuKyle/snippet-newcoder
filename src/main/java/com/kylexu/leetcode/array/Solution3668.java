package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3668 {
    public static void main(String[] args) {
        int[] order = {3, 1, 2, 5, 4};
        int[] friends = {1, 3, 4};
        int[] ints = new Solution3668().recoverOrder(order, friends);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> f = new HashSet<>();
        for (int friend : friends) {
            f.add(friend);
        }

        return Arrays.stream(order)
                .filter(f::contains)
                .toArray();
    }
}

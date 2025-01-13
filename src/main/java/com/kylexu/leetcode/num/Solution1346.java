package com.kylexu.leetcode.num;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1346 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 10, -19, 4, 6, -8};
        System.out.println(new Solution1346().checkIfExist(arr));
    }

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        int zeroCount = 0;

        Set<Integer> s = new HashSet<>();
        for (int i : arr) {
            s.add(i);
            if (i == 0) {
                zeroCount++;
            }
        }

        if (zeroCount >= 2) {
            return true;
        }

        for (int i : arr) {
            int b = i * 2;
            if (s.contains(b) && i != b) {
                return true;
            }
        }

        return false;
    }
}

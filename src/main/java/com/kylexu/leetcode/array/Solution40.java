package com.kylexu.leetcode.array;

import java.util.Arrays;
import java.util.List;

public class Solution40 {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new Solution40().combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        System.out.println("candidates = " + Arrays.toString(candidates));


        // todo
        return null;
    }
}

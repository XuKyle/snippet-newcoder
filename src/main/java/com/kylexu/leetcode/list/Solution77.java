package com.kylexu.leetcode.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = new Solution77().combine(n, k);
        System.out.println("combine = " + combine);
    }

    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        track(n, k, 1);
        return rs;
    }

    private void track(int n, int k, int startIndex) {
        if (path.size() == k) {
            rs.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            track(n, k, ++startIndex);
            path.removeLast();
        }
    }
}

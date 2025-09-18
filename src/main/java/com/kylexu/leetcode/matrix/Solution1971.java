package com.kylexu.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution1971 {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0, destination = 2;

        boolean b = new Solution1971().validPath(n, edges, source, destination);
        System.out.println("b = " + b);
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<String> paths = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            for (int e : edges[i]) {

            }

        }

        return true;
    }
}

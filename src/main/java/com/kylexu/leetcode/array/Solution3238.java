package com.kylexu.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Solution3238 {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, Map<Integer, Integer>> mark = new HashMap<>();

        for (int[] ps : pick) {
            int playerNumber = ps[0];
            int color = ps[1];

            if (mark.containsKey(playerNumber)) {
                mark.get(playerNumber).merge(color, 1, Integer::sum);
            } else {
                HashMap<Integer, Integer> counter = new HashMap<>();
                counter.put(color, 1);
                mark.put(playerNumber, counter);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : mark.entrySet()) {
            for (Integer v : entry.getValue().values()) {
                if (v > entry.getKey()) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] pick = {{0, 0}, {1, 0}, {1, 0}, {2, 1}, {2, 1}, {2, 0}};
        int i = new Solution3238().winningPlayerCount(n, pick);
        System.out.println("i = " + i);
    }
}

package com.kylexu.leetcode.array;

import java.util.Arrays;

public class Solution2410 {
    public static void main(String[] args) {
        int[] players = {4, 7, 9};
        int[] trainers = {8, 2, 5, 8};
        int i = new Solution2410().matchPlayersAndTrainers(players, trainers);
        System.out.println("i = " + i);
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int rs = 0;
        int pi = 0;
        int ti = 0;
        while (pi < players.length && ti < trainers.length) {
            if (trainers[ti] >= players[pi]) {
                rs++;
                pi++;
            }
            ti++;
        }

        return rs;
    }
}

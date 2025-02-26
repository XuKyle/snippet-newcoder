package com.kylexu.leetcode.array;

//输入：initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience = [2,6,3,1]
//输入：initialEnergy = 2, initialExperience = 4, energy = [1], experience = [3]
//输入：initialEnergy = 1, initialExperience = 1, energy = [1, 1, 1, 1], experience = [1, 1, 1, 50]
public class Solution2383 {
    public static void main(String[] args) {
        int initialEnergy = 5;
        int initialExperience = 3;
        int[] energy = new int[]{1, 4, 3, 2};
        int[] experience = new int[]{2, 6, 3, 1};
        System.out.println(new Solution2383().minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int needExperience = 0;
        int currentExperience = initialExperience;

        for (int exp : experience) {
            if (currentExperience <= exp) {
                int gap = exp - currentExperience + 1;
                needExperience += gap;
                currentExperience += gap;
            }
            currentExperience += exp;
        }

        int allNeedEnergy = 0;
        for (int i : energy) {
            allNeedEnergy += i;
        }

        int needEnergy = allNeedEnergy < initialEnergy ? 0 : allNeedEnergy - initialEnergy + 1;

        return needEnergy + needExperience;
    }
}

package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution3477V1 {
    public static void main(String[] args) {
        int[] fruits = {3, 6, 1};
        int[] baskets = {6, 4, 7};
        int i = new Solution3477V1().numOfUnplacedFruits(fruits, baskets);
        System.out.println("i = " + i);
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        List<Integer> ocuppied = new ArrayList<>();
        int rs = 0;

        for (int fruit : fruits) {
            for (int i = 0; i < baskets.length; i++) {
                if (!ocuppied.contains(i) && baskets[i] >= fruit) {
                    rs++;
                    ocuppied.add(i);
                    break;
                }
            }
        }

        return fruits.length - rs;
    }
}

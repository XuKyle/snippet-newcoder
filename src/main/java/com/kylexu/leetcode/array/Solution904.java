package com.kylexu.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Solution904 {
    public static void main(String[] args) {
        int[] fruits = {1, 0, 2, 3, 4};
        int i = new Solution904().totalFruit(fruits);
        System.out.println("i = " + i);
    }

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

public class Solution748 {
    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        String s = new Solution748().shortestCompletingWord(licensePlate, words);
        System.out.println("s = " + s);
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> counter = counter(licensePlate);
        int minLength = Integer.MAX_VALUE;
        String rs = "";

        for (String word : words) {
            Map<Character, Integer> counter1 = counter(word);
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
                if (!counter1.containsKey(entry.getKey())) {
                    flag = false;
                    break;
                }
                if (counter1.get(entry.getKey()) < entry.getValue()) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                if (word.length() < minLength) {
                    minLength = word.length();
                    rs = word;
                }
            }
        }

        return rs;
    }

    private Map<Character, Integer> counter(String str) {
        Map<Character, Integer> rs = new HashMap<>();
        for (char c : str.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                rs.merge(c, 1, Integer::sum);
            }
        }
        return rs;
    }
}

package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2506 {
    public static void main(String[] args) {
        String[] words = new String[]{"dcedceadceceaeddcedc", "dddcebcedcdbaeaaaeab", "eecbeddbddeadcbbbdbb", "decbcbebbddceacdeadd", "ccbddbaedcadedbcaaae", "dddcaadaceaedcdceedd", "bbeddbcbbccddcaceeea", "bdabacbbdadabbbddaea"};
        System.out.println(new Solution2506().similarPairs(words));
    }

    public int similarPairs(String[] words) {
        Map<String, List<Integer>> counter = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = arrange(words[i]);
            counter.computeIfAbsent(word, k -> new ArrayList<>()).add(i);
        }

        int rs = 0;
        for (Map.Entry<String, List<Integer>> entry : counter.entrySet()) {
            int size = entry.getValue().size();
            if (size != 1) {
                rs += fac(size);
            }
        }
        return rs;
    }

    private int fac(int size) {
        int rs = 0;
        for (int i = 0; i < size; i++) {
            rs += (size - 1 - i);
        }
        return rs;
    }

    private String arrange(String word) {
        return word.chars().distinct()
                .sorted()
                .mapToObj(s -> String.valueOf((char) s))
                .collect(Collectors.joining());
    }
}

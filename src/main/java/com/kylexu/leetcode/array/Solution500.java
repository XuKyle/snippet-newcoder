package com.kylexu.leetcode.array;

import java.util.*;

public class Solution500 {
    public static void main(String[] args) {
        String[] words = new String[]{"adsdf", "sfd"};
        String[] rs = new Solution500().findWords(words);
        System.out.println("rs = " + Arrays.toString(rs));
    }

    public String[] findWords(String[] words) {
//        第一行由字符 "qwertyuiop" 组成。
//        第二行由字符 "asdfghjkl" 组成。
//        第三行由字符 "zxcvbnm" 组成。
        Set<Character> line1 = new HashSet<>();
        Set<Character> line2 = new HashSet<>();
        Set<Character> line3 = new HashSet<>();

        for (char c : "qwertyuiop".toCharArray()) {
            line1.add(c);
        }
        for (char c : "asdfghjkl".toCharArray()) {
            line2.add(c);
        }
        for (char c : "zxcvbnm".toCharArray()) {
            line3.add(c);
        }

        List<String> rs = new ArrayList<>();

        for (String word : words) {
            if (containAll(line1, word) || containAll(line2, word) || containAll(line3, word)) {
                rs.add(word);
            }
        }
        return rs.toArray(new String[]{});
    }

    private boolean containAll(Set<Character> characters, String word) {
        boolean rs = true;
        for (char c : word.toLowerCase().toCharArray()) {
            if (!characters.contains(c)) {
                rs = false;
                break;
            }
        }

        return rs;
    }
}

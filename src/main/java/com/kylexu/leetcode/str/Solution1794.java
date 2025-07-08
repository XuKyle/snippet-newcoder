package com.kylexu.leetcode.str;

public class Solution1794 {
    public static void main(String[] args) {
        String word = "bza";
        int i = new Solution1794().minTimeToType(word);
        System.out.println("i = " + i);
    }

    public int minTimeToType(String word) {
        int rs = 0;

        int n = word.length();
        char[] charArray = word.toCharArray();
        char lastChar = 'a';
        for (int i = 0; i < n; i++) {
            // 当前字符与上一个字符的最短距离。
            char current = charArray[i];
            char max = current >= lastChar ? current : lastChar;
            char min = current >= lastChar ? lastChar : current;

            rs += Math.min(max - min, Math.abs(26 - max + min));

            // 输入字符需要耗费的时间
            rs++;
            lastChar = current;
        }

        return rs;
    }
}

package com.kylexu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * 示例 2：
 * <p>
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 */
public class Solution1078 {
    public static void main(String[] args) {
        String text = "we will we will rock you";
        String first = "we";
        String second = "will";

        String[] ocurrences = new Solution1078().findOcurrences(text, first, second);
        System.out.println("ocurrences = " + Arrays.toString(ocurrences));
    }

    public String[] findOcurrences(String text, String first, String second) {
        List<String> rs = new ArrayList<>();

        String[] strings = text.split("\\s+");
        int n = strings.length;
        for (int i = 0; i < n - 2; i++) {
            if (first.equals(strings[i]) && second.equals(strings[i + 1])) {
                rs.add(strings[i + 2]);
            }
        }

        return rs.toArray(new String[0]);
    }
}

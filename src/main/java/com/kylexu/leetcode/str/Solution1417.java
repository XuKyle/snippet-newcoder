package com.kylexu.leetcode.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 */
public class Solution1417 {
    public static void main(String[] args) {
        String s = "1229857369";
        System.out.println(new Solution1417().reformat(s));
    }

    public String reformat(String s) {
        List<Character> words = new ArrayList<>();
        List<Character> nums = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                nums.add(c);
            } else {
                words.add(c);
            }
        }

        int m = words.size();
        int n = nums.size();
        int max = Math.max(m, n);
        if (Math.abs(m - n) > 1) {
            return "";
        }

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < max) {
            if (m > n) {
                if (i <= m - 1) {
                    sb.append(words.get(i));
                }
                if (i <= n - 1) {
                    sb.append(nums.get(i));
                }
            } else {
                if (i <= n - 1) {
                    sb.append(nums.get(i));
                }
                if (i <= m - 1) {
                    sb.append(words.get(i));
                }
            }

            i++;
        }

        return sb.toString();
    }
}

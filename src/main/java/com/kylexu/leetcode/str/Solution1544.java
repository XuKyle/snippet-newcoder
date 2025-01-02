package com.kylexu.leetcode.str;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 示例 2：
 * <p>
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * 示例 3：
 * <p>
 * 输入：s = "s"
 * 输出："s"
 */
public class Solution1544 {
    public static void main(String[] args) {
        String s = "abBAcC";
        System.out.println(new Solution1544().makeGood(s));
    }


    public String makeGood(String s) {
        Deque<Character> rs = new LinkedList<>();
        Deque<Character> left = new LinkedList<>();

        for (char c : s.toCharArray()) {
            left.add(c);
        }

        while (!left.isEmpty()) {
            if (rs.isEmpty()) {
                rs.add(left.removeFirst());
            } else {
                int a = (int) rs.peekLast();
                int b = (int) left.peekFirst();
                if (Math.abs(a - b) == 32) {
                    rs.removeLast();
                    left.removeFirst();
                } else {
                    rs.add(left.removeFirst());
                }
            }
        }

        StringBuilder rsStr = new StringBuilder();
        for (Character r : rs) {
            rsStr.append(r);
        }
        return rsStr.toString();
    }

}

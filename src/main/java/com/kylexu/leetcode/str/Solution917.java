package com.kylexu.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 917. 仅仅反转字母
 * 简单
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * <p>
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * <p>
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 */
public class Solution917 {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(new Solution917().reverseOnlyLetters(s));
    }

    public String reverseOnlyLetters(String s) {
        Map<Integer, Character> pos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                pos.put(i, s.charAt(i));
            }
        }

        int right = s.length() - 1;
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (pos.containsKey(i)) {
                rs.append(pos.get(i));
            } else {
                char reversed = s.charAt(right);
                while (!Character.isLetter(reversed)) {
                    right--;
                    reversed = s.charAt(right);
                }
                rs.append(reversed);
                right--;
            }
        }

        return rs.toString();
    }
}

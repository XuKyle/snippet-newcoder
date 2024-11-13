package com.kylexu.leetcode.str;

import java.util.*;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * 示例 1：
 * <p>
 * 输入：s = "IceCreAm"
 * 输出："AceCreIm"
 * <p>
 * 解释：
 * s 中的元音是 ['I', 'e', 'e', 'A']。反转这些元音，s 变为 "AceCreIm".
 * <p>
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 */
public class Solution345 {
    public static void main(String[] args) {
        System.out.println(new Solution345().reverseVowels("IceCreAm"));
        System.out.println(new Solution345().reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        // 'a'、'e'、'i'、'o'、'u'
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                index.add(i);
            }
        }

        return swapByIndex(index, s);
    }

    private String swapByIndex(List<Integer> index, String s) {
        int left = 0;
        int right = index.size() - 1;

        char[] charArray = s.toCharArray();
        while (left < right) {
            char temp = charArray[index.get(left)];
            charArray[index.get(left)] = charArray[index.get(right)];
            charArray[index.get(right)] = temp;
            left++;
            right--;
        }

        return new String(charArray);
    }
}

package com.kylexu.leetcode.str;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
public class Solution28 {
    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "leeto";
//        int i = new Solution28().strStr(haystack, needle);
        int i = new Solution28().strStr("a", "a");
        System.out.println("i = " + i);
    }

    public int strStr(String haystack, String needle) {

        char[] array = haystack.toCharArray();
        for (int i = 0; i < array.length && i <= array.length - needle.length(); i++) {
            if (array[i] == needle.charAt(0)) {
                boolean flag = false;
                for (int j = 0; j < needle.toCharArray().length; j++) {
                    if (array[i + j] == needle.charAt(j)) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }
}

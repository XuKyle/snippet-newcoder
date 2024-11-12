package com.kylexu.leetcode.str;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 */
public class Solution14 {

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        String s = new Solution14().longestCommonPrefix(strings);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            commonPrefix = common(commonPrefix, strs[i]);

            if ("".equals(commonPrefix)) {
                return "";
            }
        }
        return commonPrefix;
    }

    private String common(String common, String str) {
        if (str.startsWith(common)) {
            return common;
        }
        if (common.startsWith(str)) {
            return str;
        }

        int leftLength = common.length();
        int rightLength = str.length();

        int cnt = Math.min(leftLength, rightLength);
        int maxLength = 0;
        for (int i = 0; i < cnt; i++) {
            if (common.charAt(i) != str.charAt(i)) {
                maxLength = i;
                break;
            }
        }
        if (maxLength == 0) {
            return "";
        } else {
            return common.substring(0, maxLength);
        }
    }
}

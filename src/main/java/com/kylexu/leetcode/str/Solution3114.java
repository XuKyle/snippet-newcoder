package com.kylexu.leetcode.str;

/**
 * 示例 1：
 * <p>
 * 输入： s = "1?:?4"
 * <p>
 * 输出： "11:54"
 * <p>
 * 解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "11:54"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "0?:5?"
 * <p>
 * 输出： "09:59"
 * <p>
 * 解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "09:59"。
 */
public class Solution3114 {
    public static void main(String[] args) {
        String s = "1?:?4";
        String latestTime = new Solution3114().findLatestTime(s);
        System.out.println("latestTime = " + latestTime);
    }

    public String findLatestTime(String s) {
        if (s.charAt(0) == '?') {
            if (s.charAt(1) == '?') {
                s = "11" + s.substring(2);
            } else if (s.charAt(1) == '1' || s.charAt(1) == '0') {
                s = "1" + s.substring(1);
            } else {
                s = "0" + s.substring(1);
            }
        }
        if (s.charAt(1) == '?') {
            if (s.charAt(0) == '0') {
                s = s.replaceFirst("\\?", "9");
            } else {
                s = s.replaceFirst("\\?", "1");
            }
        }

        if (s.charAt(3) == '?') {
            s = s.replaceFirst("\\?", "5");
        }

        if (s.charAt(4) == '?') {
            s = s.replaceFirst("\\?", "9");
        }

        return s;
    }
}

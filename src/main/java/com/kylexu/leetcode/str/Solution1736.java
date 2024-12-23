package com.kylexu.leetcode.str;

public class Solution1736 {
    public static void main(String[] args) {
        String s = "?4:03";
        System.out.println(new Solution1736().maximumTime(s));
    }


    public String maximumTime(String time) {
        char hour1 = time.charAt(0);
        char hour2 = time.charAt(1);
        char min3 = time.charAt(3);
        char min4 = time.charAt(4);

        StringBuilder rs = new StringBuilder();
        if (hour1 == '?') {
            if (hour2 == '?') {
                hour1 = '2';
            } else if (hour2 >= '4') {
                hour1 = '1';
            } else {
                hour1 = '2';
            }
        }
        rs.append(hour1);

        if (hour2 == '?') {
            if (hour1 == '2') {
                hour2 = '3';
            } else {
                hour2 = '9';
            }
        }
        rs.append(hour2);
        rs.append(':');

        if (min3 == '?') {
            min3 = '5';
        }
        rs.append(min3);

        if (min4 == '?') {
            min4 = '9';
        }
        rs.append(min4);

        return rs.toString();
    }


//    1736. 替换隐藏数字得到的最晚时间
//            简单
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 time ，格式为  hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
//
//    有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
//
//    替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
//
//
//
//    示例 1：
//
//    输入：time = "2?:?0"
//    输出："23:50"
//    解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
//    示例 2：
//
//    输入：time = "0?:3?"
//    输出："09:39"
//    示例 3：
//
//    输入：time = "1?:22"
//    输出："19:22"
}

package com.kylexu.leetcode.str;

/**
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 * Year 的范围在 ​[1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 * <p>
 * YYYY 表示 4 位的年份。
 * MM 表示 2 位的月份。
 * DD 表示 2 位的天数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "20th Oct 2052"
 * 输出："2052-10-20"
 * 示例 2：
 * <p>
 * 输入：date = "6th Jun 1933"
 * 输出："1933-06-06"
 * 示例 3：
 * <p>
 * 输入：date = "26th May 1960"
 * 输出："1960-05-26"
 */
public class Solution1507 {
    public static void main(String[] args) {
//        String date = "20th Oct 2052";
        String date = "26th May 1960";
        System.out.println(new Solution1507().reformatDate(date));
    }

    public String reformatDate(String date) {

        String[] dateSplit = date.split("\\s+");
        String s = dateSplit[0].substring(0, dateSplit[0].length() - 2);
        String day = s.length() == 2 ? s : "0" + s;

        String[] mon = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String monthStr = dateSplit[1];
        String month = "";
        for (int i = 0; i < mon.length; i++) {
            if (monthStr.equals(mon[i])) {
                if (i < 9) {
                    month = "0" + (i + 1);
                } else {
                    month = (i + 1) + "";
                }
                break;
            }
        }

        return dateSplit[2] + "-" + month + "-" + day;
    }
}

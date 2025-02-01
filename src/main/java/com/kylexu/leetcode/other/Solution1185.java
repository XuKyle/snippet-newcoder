package com.kylexu.leetcode.other;

import java.time.LocalDate;

/**
 * 示例 1：
 * <p>
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 * <p>
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 * <p>
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 */
public class Solution1185 {
    public static void main(String[] args) {
        int day = 31;
        int month = 8;
        int year = 2019;
        System.out.println(new Solution1185().dayOfTheWeek(day, month, year));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String name = LocalDate.of(year, month, day).getDayOfWeek().name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}

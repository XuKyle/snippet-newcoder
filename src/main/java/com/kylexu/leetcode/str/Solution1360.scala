package com.kylexu.leetcode.str

import java.time.temporal.ChronoUnit
import java.time.{Duration, LocalDate}

/*
请你编写一个程序来计算两个日期之间隔了多少天。
日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。

示例 1：
输入：date1 = "2019-06-29", date2 = "2019-06-30"
输出：1
示例 2：

输入：date1 = "2020-01-15", date2 = "2019-12-31"
输出：15
 */
object Solution1360 {
  def main(args: Array[String]): Unit = {
//    val date1 = "1971-06-29"
//    val date2 = "2010-09-23"

    val date1 = "2020-01-15"
    val date2 = "2019-12-31"
    val rs = Solution1360.daysBetweenDates(date1, date2)
    println(rs)
  }

  def daysBetweenDates(date1: String, date2: String): Int = {
    Math.abs(ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)).toInt)
  }
}

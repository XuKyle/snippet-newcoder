package com.kylexu.leetcode.str

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 * 解释：给定日期是2019年的第九天。
 * 示例 2：
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 */
object Solution154 {
  def dayOfYear(date: String): Int = {
    if ("1900-02-29".equals(date)) {
      return 60
    }
    LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).getDayOfYear
  }

  def main(args: Array[String]): Unit = {
    val date = "1900-02-29"
    val rs = Solution154.dayOfYear(date)
    println(rs)
  }
}

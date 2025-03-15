package com.kylexu.leetcode.num

/**
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * 示例 1:
 * 输入: num = 100
 * 输出: "202"
 *
 * 示例 2:
 * 输入: num = -7
 * 输出: "-10"
 */
object Solution504 {
  def convertToBase7(num: Int): String = {
    val rs = new StringBuilder()
    var n = Math.abs(num)

    while (n != 0) {
      rs.append(n % 7)
      n = n / 7
    }

    if (num == 0) {
      return "0"
    } else if (num < 0) {
      rs.append("-")
    }

    rs.reverse.toString()
  }

  def main(args: Array[String]): Unit = {
    val num = -7
    val rs = Solution504.convertToBase7(num)
    println(rs)
  }
}

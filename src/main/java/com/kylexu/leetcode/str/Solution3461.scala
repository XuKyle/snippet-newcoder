package com.kylexu.leetcode.str

import scala.collection.mutable

/**
 * 示例 1：
 *
 * 输入： s = "3902"
 *
 * 输出： true
 *
 * 解释：
 *
 * 一开始，s = "3902"
 * 第一次操作：
 * (s[0] + s[1]) % 10 = (3 + 9) % 10 = 2
 * (s[1] + s[2]) % 10 = (9 + 0) % 10 = 9
 * (s[2] + s[3]) % 10 = (0 + 2) % 10 = 2
 * s 变为 "292"
 * 第二次操作：
 * (s[0] + s[1]) % 10 = (2 + 9) % 10 = 1
 * (s[1] + s[2]) % 10 = (9 + 2) % 10 = 1
 * s 变为 "11"
 * 由于 "11" 中的数字相同，输出为 true。
 * 示例 2：
 *
 * 输入： s = "34789"
 *
 * 输出： false
 *
 * 解释：
 *
 * 一开始，s = "34789"。
 * 第一次操作后，s = "7157"。
 * 第二次操作后，s = "862"。
 * 第三次操作后，s = "48"。
 * 由于 '4' != '8'，输出为 false。
 */
object Solution3461 {
  def main(args: Array[String]): Unit = {
    val s = "34789"
    val rs = Solution3461.hasSameDigits(s)
    println(rs)
  }

  def hasSameDigits(s: String): Boolean = {
    var copy = s;

    // loop count
    for (i <- 0 until copy.length - 2) {
      val current = mutable.ListBuffer[Int]()
      for (j <- 0 until copy.length - 1) {
        val v = (copy(j) - '0' + copy(j + 1) - '0') % 10
        current.append(v)
      }

      copy = current.mkString
    }

    copy.charAt(0) == copy.charAt(1)
  }
}

package com.kylexu.leetcode.str

import scala.collection.mutable

/**
 * 示例 1：
 *
 * 输入：s = "a1c1e1"
 * 输出："abcdef"
 * 解释：数字被替换结果如下：
 * - s[1] -> shift('a',1) = 'b'
 * - s[3] -> shift('c',1) = 'd'
 * - s[5] -> shift('e',1) = 'f'
 * 示例 2：
 *
 * 输入：s = "a1b2c3d4e"
 * 输出："abbdcfdhe"
 * 解释：数字被替换结果如下：
 * - s[1] -> shift('a',1) = 'b'
 * - s[3] -> shift('b',2) = 'd'
 * - s[5] -> shift('c',3) = 'f'
 * - s[7] -> shift('d',4) = 'h'
 */
object Solution1844 {
  def main(args: Array[String]): Unit = {
    val s = "a1b2c3d4e"
    val rs = Solution1844.replaceDigits(s)
    println(rs)
  }

  def replaceDigits(s: String): String = {
    val rs = mutable.StringBuilder()

    for (i <- Range(0, s.length, 2)) {
      rs.append(s.charAt(i))
      if (i + 1 < s.length) {
        val a = s.charAt(i) + s.charAt(i + 1) - '0'
        rs.append(a.toChar)
      }
    }

    rs.toString()
  }
}

package com.kylexu.leetcode.num

import scala.util.boundary
import scala.util.boundary.break

/**
 * 示例 1：
 * 输入： s = "45320"
 * 输出： "43520"
 * 解释：
 *
 * s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。
 * 示例 2：
 * 输入： s = "001"
 * 输出： "001"
 * 解释：
 * 无需进行交换，因为 s 已经是字典序最小的。
 */
object Solution3216 {
  def main(args: Array[String]): Unit = {
    val s = "45320"
    val rs = Solution3216.getSmallestString(s)
    println(rs)
  }

  def getSmallestString(s: String): String = {
    var maxChar = '0'
    var maxIndex = -1
    for (elem <- s.indices) {
      if (maxChar < s(elem)) {
        maxChar = s(elem)
        maxIndex = elem
      }
    }

    println(s"maxChar = $maxChar; maxIndex = $maxIndex")
    var odd = (maxChar - '0') % 2 == 0

    val a = boundary:
      for (elem <- s.indices.reverse) {
        var flag = (s(elem) - '0') % 2 == 0
        if (flag == odd) {
          break(elem)
        }
      }

    println(s"a = $a")

    ""
  }
}

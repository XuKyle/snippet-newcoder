package com.kylexu.leetcode.num

import scala.util.boundary
import scala.util.boundary.break

/**
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：false
 * 解释：2 只有两个除数：1 和 2 。
 * 示例 2：
 *
 * 输入：n = 4
 * 输出：true
 * 解释：4 有三个除数：1、2 和 4 。
 */
object Solution1952 {
  def main(args: Array[String]): Unit = {
    val n = 4
    val rs = Solution1952.isThree(n)
    println(rs)
  }

  def isThree(n: Int): Boolean = {
    var rs = 0

    val flag = boundary:
      for (i <- 2 until (n - 1) if i <= n / 2) {
        if (n % i == 0) {
          rs += 1
          if (rs > 1) {
            break(false)
          }
        }
      }
      true

    rs == 1
  }
}

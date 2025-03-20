package com.kylexu.leetcode.num

import scala.util.boundary
import scala.util.boundary.break

/**
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 * 示例 1：
 * 输入：n = 8
 * 输出：6
 * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 是中枢整数，因为 1 = 1 。
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：-1
 * 解释：可以证明不存在满足题目要求的整数。
 */
object Solution2485 {
  def main(args: Array[String]): Unit = {
    val n = 8
    val rs = Solution2485.pivotInteger(n)
    println(rs)
  }

  def pivotInteger(n: Int): Int = {

    val rs = boundary:
      for (i <- 1 to n) {
        val sumLeft = Range(1, i + 1).sum
        val sumRight = Range(i, n + 1).sum

        if (sumLeft == sumRight) {
          break(i)
        }
      }
      -1

    rs
  }
}

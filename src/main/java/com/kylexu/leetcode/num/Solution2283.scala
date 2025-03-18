package com.kylexu.leetcode.num

import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * 示例 1：
 *
 * 输入：num = "1210"
 * 输出：true
 * 解释：
 * num[0] = '1' 。数字 0 在 num 中出现了一次。
 * num[1] = '2' 。数字 1 在 num 中出现了两次。
 * num[2] = '1' 。数字 2 在 num 中出现了一次。
 * num[3] = '0' 。数字 3 在 num 中出现了零次。
 * "1210" 满足题目要求条件，所以返回 true 。
 * 示例 2：
 *
 * 输入：num = "030"
 * 输出：false
 * 解释：
 * num[0] = '0' 。数字 0 应该出现 0 次，但是在 num 中出现了两次。
 * num[1] = '3' 。数字 1 应该出现 3 次，但是在 num 中出现了零次。
 * num[2] = '0' 。数字 2 在 num 中出现了 0 次。
 * 下标 0 和 1 都违反了题目要求，所以返回 false 。
 */
object Solution2283 {
  def main(args: Array[String]): Unit = {
    val num = "030"
    val rs = Solution2283.digitCount(num)
    println(rs)
  }

  def digitCount(num: String): Boolean = {
    val counter = mutable.Map.empty[Int, Int]

    for (i <- 0 until num.length) {
      val current = num.substring(i, i + 1).toInt
      if (counter.contains(current)) {
        counter(current) += 1
      } else {
        counter += (current -> 1)
      }
    }

    val flag = boundary:
      for (i <- 0 until num.length) {
        if (counter.getOrElse(i, 0) != num.substring(i, i + 1).toInt) {
          break(false)
        }
      }
      true

    flag
  }
}

package com.kylexu.leetcode.num

/**
 * 如果经过以下修改得到的数字 恰好 包含数字 1 到 9 各一次且不包含任何 0 ，那么我们称数字 n 是 迷人的 ：
 * 将 n 与数字 2 * n 和 3 * n 连接 。
 * 如果 n 是迷人的，返回 true，否则返回 false 。
 * 连接 两个数字表示把它们首尾相接连在一起。比方说 121 和 371 连接得到 121371 。
 *
 * 示例 1：
 * 给你一个三位数整数 n 。
 * 输入：n = 192
 * 输出：true
 * 解释：我们将数字 n = 192 ，2 * n = 384 和 3 * n = 576 连接，得到 192384576 。这个数字包含 1 到 9 恰好各一次。
 * 示例 2：
 *
 * 输入：n = 100
 * 输出：false
 * 解释：我们将数字 n = 100 ，2 * n = 200 和 3 * n = 300 连接，得到 100200300 。这个数字不符合上述条件。
 */
object Solution2729 {
  def main(args: Array[String]): Unit = {
    val n = 100
    val rs = Solution2729.isFascinating(n)
    println(rs)
  }

  def isFascinating(n: Int): Boolean = {
    val v = n.toString + (n * 2).toString + (n * 3).toString
    v.length == 9 && v.toCharArray.distinct.count(ch => ch != '0') == 9
  }
}

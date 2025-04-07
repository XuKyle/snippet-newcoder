package com.kylexu.leetcode.num

/**
 * 输入： n = 2, w = 3, maxWeight = 15
 *
 * 输出： 4
 *
 * 解释：
 *
 * 甲板有 4 个单元格，每个集装箱的重量为 3。将所有集装箱装载后，总重量为 12，未超过 maxWeight。
 *
 * 示例 2：
 *
 * 输入： n = 3, w = 5, maxWeight = 20
 *
 * 输出： 4
 */
object Solution3492 {
  def main(args: Array[String]): Unit = {
    val n = 3
    val w = 5
    val maxWeight = 20
    val rs = Solution3492.maxContainers(n, w, maxWeight)
    println(rs)
  }

  def maxContainers(n: Int, w: Int, maxWeight: Int): Int = {
    val rs = if (n * n * w <= maxWeight) {
      n * n
    } else {
      maxWeight / w
    }

    rs
  }
}

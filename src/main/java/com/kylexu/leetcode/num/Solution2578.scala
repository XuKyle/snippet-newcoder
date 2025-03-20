package com.kylexu.leetcode.num

/**
 * 示例 1：
 * 输入：num = 4325
 * 输出：59
 * 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
 * 示例 2：
 *
 * 输入：num = 687
 * 输出：75
 * 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 */
object Solution2578 {
  def main(args: Array[String]): Unit = {
    val num = 687
    val rs = Solution2578.splitNum(num)
    println(rs)
  }

  def splitNum(num: Int): Int = {
    val rs = num.toString.sortWith(_ < _)

    var num1 = 0
    var num2 = 0
    val n = rs.length

    for (i <- Range(0, n, 2)) {
      num1 = num1 * 10 + (rs.charAt(i) - '0')
      if (i != n - 1) {
        num2 = num2 * 10 + (rs.charAt(i + 1) - '0')
      }
    }

    num1 + num2
  }
}

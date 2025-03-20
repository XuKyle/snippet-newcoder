package com.kylexu.leetcode.num

/**
 * 示例 1：
 * 输入：num = 11891
 * 输出：99009
 * 解释：
 * 为了得到最大值，我们将数字 1 替换成数字 9 ，得到 99899 。
 * 为了得到最小值，我们将数字 1 替换成数字 0 ，得到 890 。
 * 两个数字的差值为 99009 。
 * 示例 2：
 *
 * 输入：num = 90
 * 输出：99
 * 解释：
 * 可以得到的最大值是 99（将 0 替换成 9），最小值是 0（将 9 替换成 0）。
 * 所以我们得到 99 。
 */
object Solution2566 {
  def main(args: Array[String]): Unit = {
    val num = 11891
    val rs = Solution2566.minMaxDifference(num)
    println(rs)
  }

  def minMaxDifference(num: Int): Int = {
    val firstNot9Number = num.toString.find(p => p != '9').getOrElse('9').toString
    val firstNumber = num.toString.head.toString
    num.toString.replaceAll(firstNot9Number, "9").toInt - num.toString.replaceAll(firstNumber, "0").toInt
  }
}

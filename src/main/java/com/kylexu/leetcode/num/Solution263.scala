package com.kylexu.leetcode.num

/**
 * 丑数 就是只包含质因数 2、3 和 5 的 正 整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数。
 * 示例 3：
 *
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 */
object Solution263 {
  def main(args: Array[String]): Unit = {
    val n = 0
    val rs = Solution263.isUgly(n)
    println(rs)
  }

  def isUgly(n: Int): Boolean = {
    if (n == 0) {
      return false
    }
    var m = n;
    while (m % 2 == 0 || m % 3 == 0 || m % 5 == 0) {
      while (m % 2 == 0) {
        m = m / 2
      }
      while (m % 3 == 0) {
        m = m / 3
      }
      while (m % 5 == 0) {
        m = m / 5
      }
    }

    m == 1
  }
}

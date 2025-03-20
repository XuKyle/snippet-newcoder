package com.kylexu.leetcode.num

object Solution2652 {
  def main(args: Array[String]): Unit = {
    val n = 9
    val rs = Solution2652.sumOfMultiples(n)
    println(rs)
  }

  /**
   * 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
   * 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
   *
   * 示例 1：
   * 输入：n = 7
   * 输出：21
   * 解释：在 [1, 7] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7 。数字之和为 21。
   * 示例 2：
   *
   * 输入：n = 10
   * 输出：40
   * 解释：在 [1, 10] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9、10 。数字之和为 40。
   * 示例 3：
   *
   * 输入：n = 9
   * 输出：30
   * 解释：在 [1, 9] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9 。数字之和为 30。
   *
   * @param n
   * @return
   */
  def sumOfMultiples(n: Int): Int = {
    var sum = 0

    for (i <- 1 to n) {
      if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
        sum += i
      }
    }

    sum
  }
}

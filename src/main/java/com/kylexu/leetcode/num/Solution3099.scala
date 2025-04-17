package com.kylexu.leetcode.num

/**
 * 输入： x = 18
 * 输出： 9
 */
object Solution3099 {
  def main(args: Array[String]): Unit = {
    val x = 23
    val rs = Solution3099.sumOfTheDigitsOfHarshadNumber(x)
    println(rs)
  }

  def sumOfTheDigitsOfHarshadNumber(x: Int): Int = {
    val rs = sumByPosition(x)
    if (x % rs == 0) rs else -1
  }

  def sumByPosition(x: Int): Int = {
    var y = x
    var sum = 0
    while (y != 0) {
      sum += y % 10
      y = y / 10
    }
    sum
  }
}

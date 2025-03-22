package com.kylexu.leetcode.array

import scala.collection.mutable

/**
 * 整数的 数组形式  num 是按照从左到右的顺序表示其数字的数组。
 *
 * 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
 * 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
 * 示例 1：
 *
 * 输入：num = [1,2,0,0], k = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 *
 * 输入：num = [2,7,4], k = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：num = [2,1,5], k = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 */
object Solution989 {
  def main(args: Array[String]): Unit = {
    val arr = Array(2, 1, 5)
    val k = 806
    val rs = Solution989.addToArrayForm(arr, k)
    println(rs)
  }

  def addToArrayForm(num: Array[Int], k: Int): List[Int] = {
    val rs = mutable.ListBuffer.empty[Int]

    val numArray = num.reverse
    val kArray = k.toString.toCharArray.map(c => c - '0').reverse

    val n = Math.max(numArray.length, kArray.length)
    var additional = 0

    for (i <- 0 until n) {
      var current = 0
      if (i < numArray.length) {
        current += numArray(i)
      }
      if (i < kArray.length) {
        current += kArray(i)
      }

      current += additional
      rs += current % 10
      additional = current / 10
    }

    if (additional != 0) {
      rs += additional
    }

    rs.reverse.toList
  }
}

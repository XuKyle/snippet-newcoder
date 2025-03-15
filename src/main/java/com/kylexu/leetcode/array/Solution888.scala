package com.kylexu.leetcode.array

import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * 示例 1：
 * 输入：aliceSizes = [1,1], bobSizes = [2,2]
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：aliceSizes = [1,2], bobSizes = [2,3]
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：aliceSizes = [2], bobSizes = [1,3]
 * 输出：[2,3]
 * 示例 4：
 *
 * 输入：aliceSizes = [1,2,5], bobSizes = [2,4]
 * 输出：[5,4]
 */
object Solution888 {
  def main(args: Array[String]): Unit = {
    val aliceSizes = Array(1, 1)
    val bobSizes = Array(2, 2)
    val rs = Solution888.fairCandySwap(aliceSizes, bobSizes)
    println(rs.mkString("Array(", ", ", ")"))
  }

  def fairCandySwap(aliceSizes: Array[Int], bobSizes: Array[Int]): Array[Int] = {
    var aliceSum = 0
    var bobSum = 0
    var alice = mutable.Set[Int]()
    var bob = mutable.Set[Int]()

    for (elem <- aliceSizes) {
      aliceSum += elem
      alice += elem
    }

    for (elem <- bobSizes) {
      bobSum += elem
      bob += elem
    }

    val avgSum = (bobSum + aliceSum) / 2
    var rs = Array(0, 0)

    boundary:
      for (elem <- aliceSizes) {
        val tradeSize = avgSum - (aliceSum - elem)
        if (bob.contains(tradeSize)) {
          rs(0) = elem
          rs(1) = tradeSize
          break()
        }
      }

    rs
  }
}

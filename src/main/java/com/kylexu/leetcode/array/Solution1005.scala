package com.kylexu.leetcode.array

import scala.collection.mutable

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * 示例 1：
 *
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 *
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 *
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4]
 */
object Solution1005 {
  def main(args: Array[String]): Unit = {
    val num = Array(-4, -6, 9, -2, 2)
    val k = 4
    val rs = Solution1005.largestSumAfterKNegations(num, k)
    println(rs)
  }

  def largestSumAfterKNegations(nums: Array[Int], k: Int): Int = {
    val rs = nums.sortWith(_ < _)
    var negativeNum = 0
    var zeroNum = 0
    var minValue = Integer.MAX_VALUE
    val minValueIndex = new mutable.ArrayBuffer[Int]()

    for (elem <- rs.indices) {
      if (rs(elem) < 0) {
        negativeNum += 1
      } else if (rs(elem) == 0) {
        zeroNum += 1
      }
      minValue = Math.min(minValue, Math.abs(rs(elem)))
    }

    for (elem <- rs.indices) {
      if (minValue == Math.abs(rs(elem))) {
        minValueIndex += elem
      }
    }

//    println(rs.mkString("Array(", ", ", ")"))
//    println(s"negativeNum = $negativeNum; zeroNum = $zeroNum; minValue = $minValue; minValueIndex = $minValueIndex")


    if (k <= negativeNum) {
      for (i <- 0 until k) {
        rs(i) = rs(i) * -1
      }
    } else if (zeroNum != 0) {
      for (i <- 0 until negativeNum) {
        rs(i) = rs(i) * -1
      }
    } else {
      for (i <- 0 until negativeNum) {
        rs(i) = rs(i) * -1
      }
      val count = (k - negativeNum) % 2
      if (count == 1) {
        rs(minValueIndex.head) = rs(minValueIndex.head) * -1
      }
    }

    rs.sum
  }
}

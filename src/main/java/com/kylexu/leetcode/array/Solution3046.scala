package com.kylexu.leetcode.array

object Solution3046 {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 1, 2, 2, 3, 4)
    val rs = Solution3046.isPossibleToSplit(nums)
    println(rs)
  }

  def isPossibleToSplit(nums: Array[Int]): Boolean = {
    val rs = nums.groupBy(identity)
      .view
      .mapValues(_.length)
      .values
      .max

    rs <= 2
  }
}

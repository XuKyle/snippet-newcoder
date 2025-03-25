package com.kylexu.leetcode.array

object Solution1413 {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2)
    val rs = Solution1413.minStartValue(nums)
    println(rs)
  }

  def minStartValue(nums: Array[Int]): Int = {
    Math.abs(nums.scanLeft(0)(_ + _).min) + 1
  }
}

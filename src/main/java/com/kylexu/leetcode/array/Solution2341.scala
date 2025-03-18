package com.kylexu.leetcode.array

import scala.collection.mutable

object Solution2341 {
  def main(args: Array[String]): Unit = {
    val nums = Array(1)
    val rs = Solution2341.numberOfPairs(nums)
    println(rs.mkString("Array(", ", ", ")"))
  }

  def numberOfPairs(nums: Array[Int]): Array[Int] = {
    val counter = mutable.Map.empty[Int, Int]

    for (elem <- nums) {
      if (counter.contains(elem)) {
        counter(elem) += 1
      } else {
        counter += (elem -> 1)
      }
    }

    var rs = 0
    var rs1 = 0
    for ((k, v) <- counter) {
      rs += v / 2
      rs1 += v % 2
    }

    Array(rs, rs1)
  }
}

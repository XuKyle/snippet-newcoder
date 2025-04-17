package com.kylexu.leetcode.array

object Solution2974 {
  def main(args: Array[String]): Unit = {
    val nums = Array(5, 4, 2, 3)
    val rs = Solution2974.numberGame(nums)
    println(rs.mkString("Array(", ", ", ")"))

    val rs1 = Solution2974.numberGamePro(nums)
    println(rs1.mkString("Array(", ", ", ")"))
  }

  def numberGame(nums: Array[Int]): Array[Int] = {
    var rs = nums.sortWith(_ < _)

    for (i <- Range(0, nums.length, 2)) {
      val t = rs(i)
      rs(i) = rs(i + 1)
      rs(i + 1) = t
    }

    rs
  }

  def numberGamePro(nums: Array[Int]): Array[Int] = {
    nums.sorted.grouped(2).flatMap(_.reverse).toArray
  }
}

package com.kylexu.leetcode.dp

import scala.collection.mutable

object Solution70 {
  def main(args: Array[String]): Unit = {
    val n = 45
    val rs = Solution70.climbStairs(n)
    println(rs)
  }

  val mark = mutable.HashMap[Int, Int]()

  def climbStairs(n: Int): Int = {
    if (mark.contains(n)) {
      return mark.getOrElse(n, -1)
    }
    if (n == 1) {
      return 1
    }
    if (n == 2) {
      return 2
    }

    val rs = climbStairs(n - 1) + climbStairs(n - 2)
    mark(n) = rs
    rs
  }
}

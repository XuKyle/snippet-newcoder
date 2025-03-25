package com.kylexu.leetcode.str

object Solution1374 {
  def main(args: Array[String]): Unit = {
    val n = 3
    val rs = Solution1374.generateTheString(n)
    println(rs)
  }

  def generateTheString(n: Int): String = {
    if (n % 2 == 0) {
      s"${"a" * (n - 1)}b"
    } else {
      s"${"a" * n}"
    }
  }
}

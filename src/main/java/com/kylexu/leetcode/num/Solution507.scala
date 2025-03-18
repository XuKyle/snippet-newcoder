package com.kylexu.leetcode.num

import scala.util.boundary
import scala.util.boundary.break

object Solution507 {
  def main(args: Array[String]): Unit = {
    val num = 24
    val rs = Solution507.checkPerfectNumber(num)
    println(rs)
  }

  def checkPerfectNumber(num: Int): Boolean = {
    if (num == 1) return false
    var rs = 1

    val r = boundary:
      for (i <- 2 until num if i * i < num) {
        if (num % i == 0) {
          rs += i
          if (rs > num) {
            break(false)
          }
        }
      }
      true

    if (r) rs == num else false
  }
}

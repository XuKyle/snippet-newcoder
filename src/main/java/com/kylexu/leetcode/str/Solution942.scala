package com.kylexu.leetcode.str

import scala.collection.mutable

/**
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 * 示例 1：
 *
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 */
object Solution942 {
  def main(args: Array[String]): Unit = {
    val s = "DDI"
    val rs = Solution942.diStringMatch(s)
    println(rs.mkString("Array(", ", ", ")"))
  }

  def diStringMatch(s: String): Array[Int] = {
    val rs = Array.fill[Int](s.length + 1)(s.length)
    val set = new mutable.HashSet[Int]()

    for (i <- 0 until s.length) {
      set += rs(i)

      if (s.charAt(i) == 'I') {
        var currentValue = rs(i) + 1
        while (set.contains(currentValue)) {
          currentValue += 1
        }
        rs(i + 1) = currentValue
      } else {
        var currentValue = rs(i) - 1
        while (set.contains(currentValue)) {
          currentValue -= 1
        }
        rs(i + 1) = currentValue
      }
    }

    val minValue = rs.min
    for (i <- rs.indices) {
      rs(i) -= minValue
    }

    rs
  }
}

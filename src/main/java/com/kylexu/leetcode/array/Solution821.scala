package com.kylexu.leetcode.array

/**
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 *
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 *
 * 示例 1：
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 * 示例 2：
 *
 * 输入：s = "aaab", c = "b"
 * 输出：[3,2,1,0]
 */
object Solution821 {
  def main(args: Array[String]): Unit = {
    val s = "aaab"
    val c = 'b'
    val rs = Solution821.shortestToChar(s, c)
    println(rs.mkString("Array(", ", ", ")"))
  }

  def shortestToChar(s: String, c: Char): Array[Int] = {
    val rs = Array.fill(s.length)(Integer.MAX_VALUE)

    var preIndex = -1
    for (i <- 0 until s.length) {
      if (s.charAt(i) == c) {
        preIndex = i
        rs(i) = 0
      } else {
        if (preIndex != -1) {
          rs(i) = i - preIndex
        }
      }
    }

    preIndex = -1
    for (i <- Range(0, s.length).reverse) {
      if (s.charAt(i) == c) {
        preIndex = i
      }

      if (preIndex != -1) {
        rs(i) = Math.min(rs(i), (preIndex - i))
      }
    }

    rs
  }
}

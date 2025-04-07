package com.kylexu.leetcode.str

/**
 * 示例 1：
 *
 * 输入：s = "hello"
 *
 * 输出：13
 *
 * 解释：
 *
 * s 中字符的 ASCII 码分别为：'h' = 104 ，'e' = 101 ，'l' = 108 ，'o' = 111 。所以 s 的分数为 |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13 。
 *
 * 示例 2：
 *
 * 输入：s = "zaz"
 *
 * 输出：50
 *
 * 解释：
 *
 * s 中字符的 ASCII 码分别为：'z' = 122 ，'a' = 97 。所以 s 的分数为 |122 - 97| + |97 - 122| = 25 + 25 = 50 。
 */
object Solution3110 {
  def main(args: Array[String]): Unit = {
    val s = "zaz"
    val rs = Solution3110.scoreOfString(s)
    println(rs)
  }

  def scoreOfString(s: String): Int = {
//    var rs = 0
//
//    for (i <- 0 until s.length - 1) {
//      rs += Math.abs(s.charAt(i).toInt - s.charAt(i + 1).toInt)
//    }
//
//    rs

    s.toCharArray.sliding(2).map(pair => Math.abs(pair(0).toInt - pair(1).toInt)).sum
  }
}

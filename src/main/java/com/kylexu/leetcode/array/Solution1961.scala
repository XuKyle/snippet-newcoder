package com.kylexu.leetcode.array

/**
 * 示例 1：
 *
 * 输入：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
 * 输出：true
 * 解释：
 * s 可以由 "i"、"love" 和 "leetcode" 相连得到。
 * 示例 2：
 *
 * 输入：s = "iloveleetcode", words = ["apples","i","love","leetcode"]
 * 输出：false
 * 解释：
 * 数组的前缀相连无法得到 s 。
 */
object Solution1961 {
  def main(args: Array[String]): Unit = {
    val s = "iloveleetcode"
    val words = Array("i", "love", "leetcode", "apples")

    val rs = Solution1961.isPrefixString(s, words)
    println(rs)
  }

  def isPrefixString(s: String, words: Array[String]): Boolean = {
    words.scanLeft("")(_ + _).exists(_.equals(s))
  }
}

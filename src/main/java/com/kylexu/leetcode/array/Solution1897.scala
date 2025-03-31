package com.kylexu.leetcode.array

/**
 * 示例 1：
 *
 * 输入：words = ["abc","aabc","bc"]
 * 输出：true
 * 解释：将 words[1] 中的第一个 'a' 移动到 words[2] 的最前面。
 * 使 words[1] = "abc" 且 words[2] = "abc" 。
 * 所有字符串都等于 "abc" ，所以返回 true 。
 * 示例 2：
 *
 * 输入：words = ["ab","a"]
 * 输出：false
 * 解释：执行操作无法使所有字符串都相等。
 */
object Solution1897 {
  def main(args: Array[String]): Unit = {
    val words = Array("ab","a")
    val rs = Solution1897.makeEqual(words)
    println(rs)
  }

  def makeEqual(words: Array[String]): Boolean = {
    !words.flatMap(word => word.toSeq).groupBy(identity)
      .view
      .mapValues(arr => arr.length)
      .exists((ch, count) => count % words.length != 0)
  }
}

package com.kylexu.leetcode.str

/**
 * 给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。
 *
 * 返回 word 中 特殊字母 的数量。
 *
 *
 *
 * 示例 1:
 *
 * 输入：word = "aaAbcBC"
 *
 * 输出：3
 *
 * 解释：
 *
 * word 中的特殊字母是 'a'、'b' 和 'c'。
 *
 * 示例 2:
 *
 * 输入：word = "abc"
 *
 * 输出：0
 *
 * 解释：
 *
 * word 中不存在大小写形式同时出现的字母。
 *
 * 示例 3:
 *
 * 输入：word = "abBCab"
 *
 * 输出：1
 *
 * 解释：
 *
 * word 中唯一的特殊字母是 'b'。
 */
object Solution3120 {
  def main(args: Array[String]): Unit = {
    //    val word = "abc"
    val word = "abBCab"
    val rs = Solution3120.numberOfSpecialChars(word)
    println(rs)
  }

  def numberOfSpecialChars(word: String): Int = {
    word
      .filter(char => word.contains(char.toUpper))
      .filter(char => word.contains(char.toLower))
      .map(_.toUpper)
      .distinct
      .length
  }
}

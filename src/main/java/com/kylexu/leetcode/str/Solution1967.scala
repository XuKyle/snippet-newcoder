package com.kylexu.leetcode.str

/**
 * 示例 1：
 *
 * 输入：patterns = ["a","abc","bc","d"], word = "abc"
 * 输出：3
 * 解释：
 * - "a" 是 "abc" 的子字符串。
 * - "abc" 是 "abc" 的子字符串。
 * - "bc" 是 "abc" 的子字符串。
 * - "d" 不是 "abc" 的子字符串。
 * patterns 中有 3 个字符串作为子字符串出现在 word 中。
 * 示例 2：
 *
 * 输入：patterns = ["a","b","c"], word = "aaaaabbbbb"
 * 输出：2
 * 解释：
 * - "a" 是 "aaaaabbbbb" 的子字符串。
 * - "b" 是 "aaaaabbbbb" 的子字符串。
 * - "c" 不是 "aaaaabbbbb" 的字符串。
 * patterns 中有 2 个字符串作为子字符串出现在 word 中。
 * 示例 3：
 *
 * 输入：patterns = ["a","a","a"], word = "ab"
 * 输出：3
 * 解释：patterns 中的每个字符串都作为子字符串出现在 word "ab" 中。
 */
object Solution1967 {
  def main(args: Array[String]): Unit = {
    val patterns = Array("a", "a", "a")
    val word = "ab"
    val rs = Solution1967.numOfStrings(patterns, word)
    println(rs)
  }

  def numOfStrings(patterns: Array[String], word: String): Int = {
    patterns.count(str => word.contains(str))
  }
}

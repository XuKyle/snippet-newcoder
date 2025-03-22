package com.kylexu.leetcode.str

/**
 * 示例 1：
 *
 * 输入：paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * 输出："ball"
 * 解释：
 * "hit" 出现了 3 次，但它是禁用词。
 * "ball" 出现了两次（没有其他单词出现这么多次），因此它是段落中出现频率最高的非禁用词。
 * 请注意，段落中的单词不区分大小写，
 * 标点符号会被忽略（即使它们紧挨着单词，如 "ball,"），
 * 并且尽管 "hit" 出现的次数更多，但它不能作为答案，因为它是禁用词。
 * 示例 2：
 *
 * 输入：paragraph = "a.", banned = []
 * 输出："a"
 */
object Solution819 {
  def main(args: Array[String]): Unit = {
    val paragraph = "a, a, a, a, b,b,b,c, c"
    val banned = Array("a")
    val rs = Solution819.mostCommonWord(paragraph, banned)
    println(rs)
  }

  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    paragraph.split("[\\s\\W]+")
      .map(str => str.toLowerCase.replaceAll("[^a-z]", ""))
      .filter(str => !banned.contains(str))
      .groupBy(identity)
      .map((k, v) => (k, v.length))
      .maxBy(_._2)
      ._1
  }
}

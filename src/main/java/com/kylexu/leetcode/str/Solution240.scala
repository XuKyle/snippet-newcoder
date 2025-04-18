package com.kylexu.leetcode.str

/**
 * 示例 1：
 *
 * 输入：sentence = "leetcode exercises sound delightful"
 * 输出：true
 * 解释：句子中的单词是 ["leetcode", "exercises", "sound", "delightful"] 。
 * - leetcode 的最后一个字符和 exercises 的第一个字符相等。
 * - exercises 的最后一个字符和 sound 的第一个字符相等。
 * - sound 的最后一个字符和 delightful 的第一个字符相等。
 * - delightful 的最后一个字符和 leetcode 的第一个字符相等。
 * 这个句子是回环句。
 * 示例 2：
 *
 * 输入：sentence = "eetcode"
 * 输出：true
 * 解释：句子中的单词是 ["eetcode"] 。
 * - eetcode 的最后一个字符和 eetcode 的第一个字符相等。
 * 这个句子是回环句。
 * 示例 3：
 *
 * 输入：sentence = "Leetcode is cool"
 * 输出：false
 * 解释：句子中的单词是 ["Leetcode", "is", "cool"] 。
 * - Leetcode 的最后一个字符和 is 的第一个字符 不 相等。
 * 这个句子 不 是回环句。
 */
object Solution240 {
  def main(args: Array[String]): Unit = {
    val sentence = "leetcode exercises sound delightful"
    val rs = Solution240.isCircularSentence(sentence)
    println(rs)
  }


  def isCircularSentence(sentence: String): Boolean = {
    val rs = sentence.split("\\s+")
    val rsNew = rs.tail :+ rs.head
    println(s"rs = ${rs.mkString("Array(", ", ", ")")} ; rs1 = ${rsNew.mkString("Array(", ", ", ")")}")
    !rs.zip(rsNew).exists((a, b) => a.last != b.head)
  }
}

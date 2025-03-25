package com.kylexu.leetcode.str

import scala.util.boundary
import scala.util.boundary.break

/**
 * 示例 1：
 *
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 *
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 *
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 */
object Solution953 {
  def isAlienSorted(words: Array[String], order: String): Boolean = {
    val dic = order.zipWithIndex.groupBy(_._1).map((k, v) => (k, v.map(_._2)(0)))
    val max = words.map(_.length).max

    val wordOriginIndex = words.zipWithIndex.toMap

    val wordSorted = words.sortWith(
      (left, right) => {
        val maxLength = Math.max(left.length, right.length)

        val rs = boundary:
          for (i <- 0 until maxLength) {
            val leftValue = if (i >= left.length) -1 else dic.getOrElse(left.charAt(i), 0)
            val rightValue = if (i >= right.length) -1 else dic.getOrElse(right.charAt(i), 0)

            if (leftValue == rightValue) {

            } else if (leftValue < rightValue) {
              break(true)
            } else {
              break(false)
            }
          }
          true

        rs
      }
    ).zipWithIndex.toMap


    val rs = boundary:
      for ((k, v) <- wordOriginIndex) {
        if (wordSorted.getOrElse(k, -1) != v) {
          break(false)
        }
      }
      true

    rs
  }

  def main(args: Array[String]): Unit = {
    val words = Array("apple", "app")
    val order = "worldabcefghijkmnpqstuvxyz"
    val rs = Solution953.isAlienSorted(words, order)
    println(rs)
  }
}

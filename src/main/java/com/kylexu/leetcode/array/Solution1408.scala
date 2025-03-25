package com.kylexu.leetcode.array

import scala.collection.mutable

/**
 * 示例 1：
 *
 * 输入：words = ["mass","as","hero","superhero"]
 * 输出：["as","hero"]
 * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * ["hero","as"] 也是有效的答案。
 * 示例 2：
 *
 * 输入：words = ["leetcode","et","code"]
 * 输出：["et","code"]
 * 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
 * 示例 3：
 *
 * 输入：words = ["blue","green","bu"]
 * 输出：[]
 */
object Solution1408 {
  def main(args: Array[String]): Unit = {
    val words = Array("blue", "green", "bu")
    val rs = Solution1408.stringMatching(words)
    println(rs)
  }

  def stringMatching(words: Array[String]): List[String] = {
    val sortWords = words.sortWith(_.length < _.length)

    val rs = mutable.ListBuffer[String]()

    import scala.util.control.Breaks._

    for (i <- sortWords.indices) {
      breakable {
        for (j <- i + 1 until sortWords.length) {
          if (sortWords(j).contains(sortWords(i))) {
            rs += sortWords(i)
            break()
          }
        }
      }
    }

    rs.toList
  }
}

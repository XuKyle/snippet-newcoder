package com.kylexu.leetcode.str

import scala.util.boundary
import scala.util.boundary.break

/**
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 *
 * 如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 *
 * 输入：sentence = "leetcode"
 * 输出：false
 */
object Solution1832 {
  def main(args: Array[String]): Unit = {
    val sentence = "leetcode"
    val rs = Solution1832.checkIfPangram(sentence)
    println(rs)
  }

  def checkIfPangram(sentence: String): Boolean = {

    val rs = boundary:
      for (elem <- 'a' to 'z') {
        if (!sentence.contains(elem)) {
          break(false)
        }
      }
      true

    rs
  }
}

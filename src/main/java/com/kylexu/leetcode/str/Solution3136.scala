package com.kylexu.leetcode.str

import scala.util.boundary.break
import scala.util.control.Breaks.breakable

/**
 * 有效单词 需要满足以下几个条件：
 *
 * 至少 包含 3 个字符。
 * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
 * 至少 包含一个 元音字母 。
 * 至少 包含一个 辅音字母 。
 * 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
 *
 * 注意：
 *
 * 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
 * 英文中的 辅音字母 是指那些除元音字母之外的字母。
 *
 *
 * 示例 1：
 *
 * 输入：word = "234Adas"
 *
 * 输出：true
 *
 * 解释：
 *
 * 这个单词满足所有条件。
 *
 * 示例 2：
 *
 * 输入：word = "b3"
 *
 * 输出：false
 *
 * 解释：
 *
 * 这个单词的长度少于 3 且没有包含元音字母。
 *
 * 示例 3：
 *
 * 输入：word = "a3$e"
 *
 * 输出：false
 *
 * 解释：
 *
 * 这个单词包含了 '$' 字符且没有包含辅音字母。
 */
object Solution3136 {
  def main(args: Array[String]): Unit = {
    val word = "b3"
    val rs = Solution3136.isValid(word)
    println(rs)
  }

  def isValid(word: String): Boolean = {

    // * 至少 包含 3 个字符。
    // * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
    // * 至少 包含一个 元音字母 。
    // * 至少 包含一个 辅音字母 。
    // * 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
    // *
    // * 注意：
    // *
    // * 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
    // * 英文中的 辅音字母 是指那些除元音字母之外的字母。
    var condition1 = 0
    var condition2 = 0
    var condition3 = 0

    val container = Set('a', 'e', 'i', 'o', 'u')

    breakable {
      for (i <- 0 until word.length) {
        val current = word.charAt(i).toLower
        if (current >= 'a' && current <= 'z') {
          condition1 += 1
          if (container.contains(current)) {
            condition2 += 1
          } else {
            condition3 += 1
          }
        }

        if (Character.isDigit(current) || Character.isLetter(current)) {

        } else {
          return false
        }
      }
    }

    condition1 >= 3 && condition2 >= 1 && condition3 >= 1
  }
}

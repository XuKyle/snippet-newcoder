package com.kylexu.leetcode.str

import java.util

/**
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 *
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 *
 * 示例 1：
 *
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 *
 * 输入：s = "(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 *
 * 输入：s = "()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 */
object Solution1021 {
  def main(args: Array[String]): Unit = {
    val s = "()()"
    val rs = Solution1021.removeOuterParentheses(s)
    println(rs)
  }

  def removeOuterParentheses(s: String): String = {
    val index = new util.ArrayList[Int]()
    val stack = new util.LinkedList[Char]()

    for (i <- 0 until s.length) {
      val currentChar = s.charAt(i)
      if (stack.isEmpty && currentChar == '(') {
        index.add(i)
        stack.add('(')
      } else if (stack.size() == 1 && currentChar == ')') {
        index.add(i)
        stack.removeLast()
      } else {
        if (currentChar == '(') {
          stack.add('(')
        } else if (currentChar == ')') {
          stack.removeLast()
        }
      }
    }

    val strBuilder = new StringBuilder(s)
    for (i <- Range(0, index.size()).reverse) {
      strBuilder.deleteCharAt(index.get(i))
    }

    strBuilder.toString()
  }
}

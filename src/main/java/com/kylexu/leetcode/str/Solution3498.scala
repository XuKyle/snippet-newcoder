package com.kylexu.leetcode.str

/**
 * 示例 1：
 *
 * 输入： s = "abc"
 *
 * 输出： 148
 *
 * 解释：
 *
 * 字母	反转字母表中的位置	字符串中的位置	乘积
 * 'a'	26	1	26
 * 'b'	25	2	50
 * 'c'	24	3	72
 * 反转度是 26 + 50 + 72 = 148 。
 *
 * 示例 2：
 *
 * 输入： s = "zaza"
 *
 * 输出： 160
 */
object Solution3498 {
  def main(args: Array[String]): Unit = {
    val s = "abc"
    val rs = Solution3498.reverseDegree(s)
    println(rs)
  }

  def reverseDegree(s: String): Int = {
    s.toCharArray
      .zipWithIndex
      .map {
        (ch, index) => {
          (26 - (ch - 'a')) * (index + 1)
        }
      }
      .sum
  }

}

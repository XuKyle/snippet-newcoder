package com.kylexu.leetcode.str

import scala.collection.mutable

/**
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 *
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * 示例 1：
 *
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * 示例 2：
 *
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * 示例 3：
 *
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 */
object Solution859 {
  def main(args: Array[String]): Unit = {
    // todo
    val s = "ab"
    val goal = "ba"
    val rs = Solution859.buddyStrings(s, goal)
    println(rs)
  }

  def buddyStrings(s: String, goal: String): Boolean = {
    if (s.eq(goal)) {
      return true
    }

    if (s.length != goal.length) {
      return false
    }

    val diffS = mutable.Set[Char]()
    val diffGoal = mutable.Set[Char]()

    for (i <- 0 to s.length) {
      if (s.charAt(i) != goal.charAt(i)) {
        diffS.add(s.charAt(i))
        diffGoal.add(goal.charAt(i))
      }
    }


    true
  }
}

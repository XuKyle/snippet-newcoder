package com.kylexu.leetcode.array

/**
 * 示例 1：
 *
 * 输入：words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
 * 输出：1
 * 解释：从下标 1 开始，可以经由以下步骤到达 "hello" ：
 * - 向右移动 3 个单位，到达下标 4 。
 * - 向左移动 2 个单位，到达下标 4 。
 * - 向右移动 4 个单位，到达下标 0 。
 * - 向左移动 1 个单位，到达下标 0 。
 * 到达 "hello" 的最短距离是 1 。
 * 示例 2：
 *
 * 输入：words = ["a","b","leetcode"], target = "leetcode", startIndex = 0
 * 输出：1
 * 解释：从下标 0 开始，可以经由以下步骤到达 "leetcode" ：
 * - 向右移动 2 个单位，到达下标 3 。
 * - 向左移动 1 个单位，到达下标 3 。
 * 到达 "leetcode" 的最短距离是 1 。
 * 示例 3：
 *
 * 输入：words = ["i","eat","leetcode"], target = "ate", startIndex = 0
 * 输出：-1
 * 解释：因为 words 中不存在字符串 "ate" ，所以返回 -1 。
 */
object Solution2515 {
  def main(args: Array[String]): Unit = {
    val words = Array("a", "b", "leetcode")
    val target = "leetcode"
    val startIndex = 0

    val rs = Solution2515.closestTarget(words = words, target = target, startIndex = startIndex)
    println(rs)
  }

  def closestTarget(words: Array[String], target: String, startIndex: Int): Int = {
    if (!words.contains(target)) {
      return -1
    }

    val n = words.length
    var rs = Integer.MAX_VALUE

    for (i <- startIndex until startIndex + n) {
      if (words(i % n).equals(target)) {
        rs = Math.min(rs, i - startIndex)
      }
    }

    for (i <- Range(startIndex, startIndex - n, -1)) {
      val index = if (i < 0) {
        i + n
      } else {
        i
      }
      if (words(index).equals(target)) {
        rs = Math.min(rs, Math.abs(i - startIndex))
      }
    }

    rs
  }
}

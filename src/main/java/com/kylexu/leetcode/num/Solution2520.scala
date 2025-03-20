package com.kylexu.leetcode.num

/**
 * 示例 1：
 * 输入：num = 7
 * 输出：1
 * 解释：7 被自己整除，因此答案是 1 。
 * 示例 2：
 *
 * 输入：num = 121
 * 输出：2
 * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
 * 示例 3：
 *
 * 输入：num = 1248
 * 输出：4
 * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
 */
object Solution2520 {
  def main(args: Array[String]): Unit = {
    val num = 7
    val rs = Solution2520.countDigits(num)
    println(rs)
  }

  def countDigits(num: Int): Int = {
    var copyNum = num
    var rs = 0

    while (copyNum != 0) {
      if (num % (copyNum % 10) == 0) {
        rs += 1
      }
      copyNum = copyNum / 10
    }

    rs
  }
}

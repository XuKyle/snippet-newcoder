package com.kylexu.leetcode.array

/**
 * 示例 1：
 *
 * 输入：details = ["7868190130M7522","5303914400F9211","9273338290F4010"]
 * 输出：2
 * 解释：下标为 0 ，1 和 2 的乘客年龄分别为 75 ，92 和 40 。所以有 2 人年龄大于 60 岁。
 * 示例 2：
 *
 * 输入：details = ["1313579440F2036","2921522980M5644"]
 * 输出：0
 * 解释：没有乘客的年龄大于 60 岁。
 */
object Solution2678 {
  def main(args: Array[String]): Unit = {
    val details = Array("7868190130M7522", "5303914400F9211", "9273338290F4010")
    val rs = Solution2678.countSeniors(details)
    println(rs)
  }

  def countSeniors(details: Array[String]): Int = {
    details.map(str => str.substring(11, 13).toInt).count(_ > 60)
  }
}

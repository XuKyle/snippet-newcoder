package com.kylexu.leetcode.str


/**
 * 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
 * 示例 1：
 *
 * 输入：coordinates = "a1"
 * 输出：false
 * 解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
 * 示例 2：
 *
 * 输入：coordinates = "h3"
 * 输出：true
 * 解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
 * 示例 3：
 *
 * 输入：coordinates = "c7"
 * 输出：false
 */
object Solution1812 {
  def main(args: Array[String]): Unit = {
    val coordinates = "a1"
    val rs = Solution1812.squareIsWhite(coordinates)
    println(rs)
  }

  def squareIsWhite(coordinates: String): Boolean = {
    val rowNumber = coordinates(0) - ('a' - 1)
    val columnNumber = coordinates(1)

    ((rowNumber % 2) == 0) != (columnNumber % 2 == 0)
  }
}

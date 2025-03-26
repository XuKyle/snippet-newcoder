package com.kylexu.leetcode.array

/**
 * 示例 1：
 *
 * 输入：points = [[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：false
 */
object Solution1037 {
  def main(args: Array[String]): Unit = {
    val points = Array(
      Array(1, 1),
      Array(2, 3),
      Array(3, 2)
    )
    val rs = Solution1037.isBoomerang(points)
    println(rs)
  }

  def isBoomerang(points: Array[Array[Int]]): Boolean = {
    val x1 = points(0)(0) - points(1)(0)
    val y1 = points(0)(1) - points(1)(1)

    val x2 = points(0)(0) - points(2)(0)
    val y2 = points(0)(1) - points(2)(1)

    x1 * y2 != y1 * x2
  }
}

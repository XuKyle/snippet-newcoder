package com.kylexu.leetcode.array

import scala.util.boundary
import scala.util.boundary.break

/**
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 */
object Solution1232 {
  def checkStraightLine(coordinates: Array[Array[Int]]): Boolean = {
    //    由斜率公式得
    //    (y1 - y0) / (x1 - x0) = (yi - y0) / (xi - x0)
    //    防止除0
    //    ，变换成相乘的形式
    //    (y1 - y0) * (xi - x0) == (x1 - x0) * (yi - y0)

    val rs = boundary:
      for (i <- 2 until coordinates.length) {
        if ((coordinates(1)(1) - coordinates(0)(1)) * (coordinates(i)(0) - coordinates(0)(0))
          !=
          ((coordinates(1)(0) - coordinates(0)(0)) * (coordinates(i)(1) - coordinates(0)(1)))
        ) {
          break(false)
        }
      }
      true

    rs
  }

  def main(args: Array[String]): Unit = {
    val coordinates = Array(
      Array(1, 2),
      Array(2, 3),
      Array(3, 4),
      Array(4, 5),
      Array(5, 6),
      Array(6, 7)
    )

    val rs = Solution1232.checkStraightLine(coordinates)
    println(rs)
  }


}

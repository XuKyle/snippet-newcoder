package com.kylexu.leetcode.array

import scala.util.boundary
import scala.util.boundary.break

/**
 * 示例 1：
 *
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 * 示例 2：
 *
 * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出：91
 */
object Solution1710 {
  def main(args: Array[String]): Unit = {
    val boxTypes = Array(
      Array(5, 10),
      Array(2, 5),
      Array(4, 7),
      Array(3, 9),
    )
    val truckSize = 10
    val rs = Solution1710.maximumUnits(boxTypes = boxTypes, truckSize = truckSize)
    println(rs)
  }

  def maximumUnits(boxTypes: Array[Array[Int]], truckSize: Int): Int = {
    val sorter = boxTypes.sortBy(arr => -1 * arr(1))

    var sum = 0
    var size = 0
    val rs = boundary:
      for (i <- sorter.indices) {
        val current = sorter(i)
        if (size + current(0) >= truckSize) {
          sum += ((truckSize - size) * current(1))
          break(sum)
        } else {
          sum += current(0) * current(1)
        }
        size += current(0)
      }
      sum

    rs
  }
}

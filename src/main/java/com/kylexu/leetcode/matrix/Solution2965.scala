package com.kylexu.leetcode.matrix

/**
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
 * 任务是找出重复的数字a 和缺失的数字 b 。
 * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
 *
 * 示例 1：
 *
 * 输入：grid = [[1,3],[2,2]]
 * 输出：[2,4]
 * 解释：数字 2 重复，数字 4 缺失，所以答案是 [2,4] 。
 * 示例 2：
 *
 * 输入：grid = [[9,1,7],[8,9,2],[3,4,6]]
 * 输出：[9,5]
 * 解释：数字 9 重复，数字 5 缺失，所以答案是 [9,5] 。
 */
object Solution2965 {
  def main(args: Array[String]): Unit = {
    //    val grid = Array(
    //      Array(9, 1, 7),
    //      Array(8, 9, 2),
    //      Array(3, 4, 6)
    //    )

    val grid = Array(
      Array(1, 3),
      Array(2, 2)
    )
    val rs = Solution2965.findMissingAndRepeatedValues(grid)
    println(rs.mkString("Array(", ", ", ")"))
  }

  def findMissingAndRepeatedValues(grid: Array[Array[Int]]): Array[Int] = {
    var sum = 0

    //    val duplicateNumber = grid.flatten().groupBy(identity).view.mapValues(_.length).find((k, v) => v == 2).get._1
    val duplicateNumber = grid.reduce(_ ++ _).groupBy(identity).view.mapValues(_.length).find((k, v) => v == 2).get._1
    for (elem <- grid) {
      sum += elem.sum
    }
    val n = grid.length * grid.length
    val missNumber = Range(1, n + 1).sum - (sum - duplicateNumber)

    Array[Int](duplicateNumber, missNumber)
  }
}

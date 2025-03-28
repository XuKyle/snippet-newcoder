package com.kylexu.leetcode.matrix

/**
 * 示例 1：
 *
 * 输入：m = 2, n = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 * 示例 2：
 *
 *
 *
 * 输入：m = 2, n = 2, indices = [[1,1],[0,0]]
 * 输出：0
 * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
 */
object Solution1252 {
  def main(args: Array[String]): Unit = {
    val m = 2
    val n = 2
    val indices = Array(
      Array(1, 1),
      Array(0, 0)
    )
    val rs = Solution1252.oddCells(m = m, n = n, indices = indices)
    println(rs)
  }

  def oddCells(m: Int, n: Int, indices: Array[Array[Int]]): Int = {
    val matrix = Array.ofDim[Int](m, n)

    for (elem <- indices) {
      val row = elem(0)
      val column = elem(1)

      for (elem <- matrix(row).indices) {
        matrix(row)(elem) += 1
      }

      for (i <- matrix.indices) {
        matrix(i)(column) += 1
      }
    }

    var rs = 0
    for (elem <- matrix) {
      for (el <- elem) {
        if (el % 2 == 1) {
          rs += 1
        }
      }
    }
    rs
  }
}

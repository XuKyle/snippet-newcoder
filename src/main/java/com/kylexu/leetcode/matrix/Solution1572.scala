package com.kylexu.leetcode.matrix

/**
 * 输入：mat = [[1,2,3],
 *             [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * 示例  2：
 *
 * 输入：mat = [[1,1,1,1],
 *             [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * 示例 3：
 *
 * 输入：mat = [[5]]
 * 输出：5
 */
object Solution1572 {
  def main(args: Array[String]): Unit = {
    val mat = Array(
      Array(5)
    )

    val rs = Solution1572.diagonalSum(mat)
    println(rs)
  }

  def diagonalSum(mat: Array[Array[Int]]): Int = {
    val m = mat.length
    val n = mat(0).length

    var rs = 0
    for (i <- 0 until m) {
      val left = i
      val right = m - i - 1

      rs += mat(i)(left)
      if (left != right) {
        rs += mat(i)(right)
      }
    }

    rs
  }
}

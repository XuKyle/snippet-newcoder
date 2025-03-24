package com.kylexu.leetcode.matrix

/**
 * 示例 1：
 *
 * 输入：image = [[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2：
 *
 * 输入：image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */
object Solution832 {
  def main(args: Array[String]): Unit = {
    val image = Array(
      Array(1, 1, 0),
      Array(1, 0, 1),
      Array(0, 0, 0)
    )

    val rs = Solution832.flipAndInvertImage(image)
    for (elem <- rs) {
      println(elem.mkString("Array(", ", ", ")"))
    }
  }

  def flipAndInvertImage(image: Array[Array[Int]]): Array[Array[Int]] = {
    val rows = image.length
    val cols = image(0).length

    val rs = Array.ofDim[Int](rows, cols)
    for (i <- 0 until rows) {
      for (j <- 0 until cols) {
        rs(i)(j) = image(i)(j)
      }
    }

    for (i <- 0 until rows) {
      val current = image(i)
      val n = current.length
      val reverse = Array.fill[Int](current.length)(0)
      for (j <- 0 until n) {
        reverse(n - 1 - j) = if (current(j) == 0) 1 else 0
      }
      rs(i) = reverse
    }

    rs
  }
}

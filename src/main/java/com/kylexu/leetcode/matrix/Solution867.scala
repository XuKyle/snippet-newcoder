package com.kylexu.leetcode.matrix

//给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
//
//矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

//示例 1：
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[1,4,7],[2,5,8],[3,6,9]]
//示例 2：
//
//输入：matrix = [[1,2,3],[4,5,6]]
//输出：[[1,4],[2,5],[3,6]]

object Solution867 {
  def main(args: Array[String]): Unit = {
    val matrix = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
    )
    val rs = Solution867.transpose(matrix = matrix)
    rs.foreach(
      row => println(row.mkString(" | "))
    )
  }

  def transpose(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val m = matrix.length
    val n = matrix(0).length

    val rs = Array.ofDim[Int](n, m)

    for (i <- 0 until m) {
      for (j <- 0 until n) {
        rs(j)(i) = matrix(i)(j)
      }
    }

    rs
  }

}

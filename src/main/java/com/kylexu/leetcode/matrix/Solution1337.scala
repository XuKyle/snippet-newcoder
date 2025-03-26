package com.kylexu.leetcode.matrix

/**
 * 示例 1：
 *
 * 输入：mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 *
 * 输入：mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 */
object Solution1337 {
  def main(args: Array[String]): Unit = {
    val mat = Array(
      Array(1, 1, 0, 0, 0),
      Array(1, 1, 1, 1, 0),
      Array(1, 0, 0, 0, 0),
      Array(1, 1, 0, 0, 0),
      Array(1, 1, 1, 1, 1)
    )

    val rs = Solution1337.kWeakestRows(mat = mat, k = 3)
    println(rs.mkString("Array(", ", ", ")"))
  }

  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    //    mat.zipWithIndex
    //      .map((elem, index) => (elem.sum, index))
    //      .sortWith(
    //        (left, right) => {
    //          if (left._1 == right._1) {
    //            left._2 < right._2
    //          } else {
    //            left._1 < right._1
    //          }
    //        }
    //      ).map(_._2)
    //      .take(k)

    //    用 sortBy 替代 sortWith ：
    //    原 sortWith 逻辑 ：手动比较 sum 和 index
    //
    //    ：直接对元组(sum, index) 排序
    //    ，利用 Scala 元组的自然顺序比较​
    //    （先按 sum
    //    ，再按 index），无需显式条件判断

    mat.zipWithIndex
      .map((elem, index) => (elem.sum, index))
      .sortBy {
        case (rowSum, index) => (rowSum, index)
      }.map(_._2)
      .take(k)
  }
}

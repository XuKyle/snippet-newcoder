package com.kylexu.leetcode.array

/**
 * 输入：original = [1,2,3,4], m = 2, n = 2
 * 输出：[[1,2],[3,4]]
 * 解释：
 * 构造出的二维数组应该包含 2 行 2 列。
 * original 中第一个 n=2 的部分为 [1,2] ，构成二维数组的第一行。
 * original 中第二个 n=2 的部分为 [3,4] ，构成二维数组的第二行。
 * 示例 2：
 *
 * 输入：original = [1,2,3], m = 1, n = 3
 * 输出：[[1,2,3]]
 * 解释：
 * 构造出的二维数组应该包含 1 行 3 列。
 * 将 original 中所有三个元素放入第一行中，构成要求的二维数组。
 * 示例 3：
 *
 * 输入：original = [1,2], m = 1, n = 1
 * 输出：[]
 * 解释：
 * original 中有 2 个元素。
 * 无法将 2 个元素放入到一个 1x1 的二维数组中，所以返回一个空的二维数组。
 * 示例 4：
 *
 * 输入：original = [3], m = 1, n = 2
 * 输出：[]
 * 解释：
 * original 中只有 1 个元素。
 * 无法将 1 个元素放满一个 1x2 的二维数组，所以返回一个空的二维数组。
 */
object Solution2022 {
  def main(args: Array[String]): Unit = {
    val original = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val m = 3
    val n = 3
    val rs = Solution2022.construct2DArray(original = original, m = m, n = n)
    for (elem <- rs) {
      println(elem.mkString("Array(", ",", ")"))
    }
  }

  def construct2DArray(original: Array[Int], m: Int, n: Int): Array[Array[Int]] = {
    if (original.length != m * n) {
      return Array()
    }

    val rs = Array.ofDim[Int](m, n)

    for (i <- 0 until m) {
      for (j <- 0 until n) {
        rs(i)(j) = original(i * n + j)
      }
    }

    rs
  }
}

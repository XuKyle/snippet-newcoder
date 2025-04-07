package com.kylexu.leetcode.matrix

/**
 * 示例 1：
 *
 * 输入：mat = [[0,1],[1,0]]
 * 输出：[0,1]
 * 解释：两行中 1 的数量相同。所以返回下标最小的行，下标为 0 。该行 1 的数量为 1 。所以，答案为 [0,1] 。
 * 示例 2：
 *
 * 输入：mat = [[0,0,0],[0,1,1]]
 * 输出：[1,2]
 * 解释：下标为 1 的行中 1 的数量最多。该行 1 的数量为 2 。所以，答案为 [1,2] 。
 * 示例 3：
 *
 * 输入：mat = [[0,0],[1,1],[0,0]]
 * 输出：[1,2]
 * 解释：下标为 1 的行中 1 的数量最多。该行 1 的数量为 2 。所以，答案为 [1,2] 。
 */
object Solution2643 {
  def main(args: Array[String]): Unit = {
    val mat = Array(
      Array(0, 0),
      Array(1, 1),
      Array(0, 1)
    )
    val rs = Solution2643.rowAndMaximumOnes(mat)
    println(rs.mkString("Array(", ", ", ")"))
  }

  def rowAndMaximumOnes(mat: Array[Array[Int]]): Array[Int] = {
    var maxCount = 0
    var maxCountIndex = Integer.MAX_VALUE

    for (i <- mat.indices.reverse) {
      val current = mat(i)
      val currentCount = current.count(p => p == 1)
      maxCount = Math.max(currentCount, maxCount)

      if (currentCount == maxCount) {
        maxCountIndex = Math.min(maxCountIndex, i)
      }
    }

    Array(maxCountIndex, maxCount)
  }
}

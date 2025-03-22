package com.kylexu.leetcode.matrix

/**
 * 给你一组多米诺骨牌 dominoes 。
 *
 * 形式上，dominoes[i] = [a, b] 与 dominoes[j] = [c, d] 等价 当且仅当 (a == c 且 b == d) 或者 (a == d 且 b == c) 。即一张骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 * 示例 1：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * 示例 2：
 *
 * 输入：dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
 * 输出：3
 */
object Solution1128 {
  def numEquivDominoPairs(dominoes: Array[Array[Int]]): Int = {
    var rs = 0

    for (i <- dominoes.indices) {
      val current = dominoes(i)
      for (j <- i + 1 until dominoes.length) {
        val next = dominoes(j)

        if ((current(0) == next(0) && current(1) == next(1)) || (current(0) == next(1) && current(1) == next(0))) {
          rs += 1
        }
      }
    }

    rs
  }

  def main(args: Array[String]): Unit = {
    //    [[1,2],[1,2],[1,1],[1,2],[2,2]]
    val dominoes = Array(
      Array(1, 2),
      Array(2, 1),
      Array(1, 1),
      Array(1, 2),
      Array(2, 2)
    )

    val rs = Solution1128.numEquivDominoPairs(dominoes)

    println(rs)
  }
}

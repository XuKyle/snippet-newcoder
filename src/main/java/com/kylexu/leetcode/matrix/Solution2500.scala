package com.kylexu.leetcode.matrix

object Solution2500 {

  def deleteGreatestValue(grid: Array[Array[Int]]): Int = {
    // todo
    val rs = grid.map(_.sortWith(_ > _))
      .sortWith {
        (a, b) =>
          a.zip(b).collectFirst {
            case (x, y) if (x != y) => x > y
          }.getOrElse(false)
      }

    var sum = 0
    var i = 0

    for (elem <- grid.indices) {
      sum += grid(elem)(i)
      i += 1
    }

    sum
  }

  // grid = [[1,2,4],[3,3,1]]
  def main(args: Array[String]): Unit = {
    val grid = Array(
      Array(1, 2, 4),
      Array(3, 3, 1)
    )
    val rs = Solution2500.deleteGreatestValue(grid)
    println(rs)
  }
}

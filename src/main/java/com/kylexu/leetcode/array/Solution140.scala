package com.kylexu.leetcode.array

/**
 * 示例 1：
 * 输入：questions = [[3,2],[4,3],[4,4],[2,5]]
 * 输出：5
 * 解释：解决问题 0 和 3 得到最高分。
 * - 解决问题 0 ：获得 3 分，但接下来 2 个问题都不能解决。
 * - 不能解决问题 1 和 2
 * - 解决问题 3 ：获得 2 分
 * 总得分为：3 + 2 = 5 。没有别的办法获得 5 分或者多于 5 分。
 * 示例 2：
 *
 * 输入：questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
 * 输出：7
 * 解释：解决问题 1 和 4 得到最高分。
 * - 跳过问题 0
 * - 解决问题 1 ：获得 2 分，但接下来 2 个问题都不能解决。
 * - 不能解决问题 2 和 3
 * - 解决问题 4 ：获得 5 分
 * 总得分为：2 + 5 = 7 。没有别的办法获得 7 分或者多于 7 分。
 */
object Solution140 {
  def main(args: Array[String]): Unit = {
    //    [1,1],[2,2],[3,3],[4,4],[5,5]
    //    val questions = Array(
    //      Array(3, 2),
    //      Array(4, 3),
    //      Array(4, 4),
    //      Array(2, 5)
    //    )

    //    val questions = Array(
    //      Array(1, 1),
    //      Array(2, 2),
    //      Array(3, 3),
    //      Array(4, 4),
    //      Array(5, 5)
    //    )
    //      [[12,46],[78,19],[63,15],[79,62],[13,10]]
    val questions = Array(
      Array(12, 46),
      Array(78, 19),
      Array(63, 15),
      Array(79, 62),
      Array(13, 10)
    )
    val rs = Solution140.mostPoints(questions)
    println(rs)
  }

  def mostPoints(questions: Array[Array[Int]]): Long = {
    //    val rs = questions.zipWithIndex.groupBy((elem, index) => index % 3)
    //      .view
    //      .toMap
    //      .map {
    //        case (i, tuples) =>
    //          tuples.map {
    //            case (ints, i) => ints.head
    //          }.sum
    //      }.max
    //
    //    rs

    var rs = 0
    for (i <- questions.indices) {
      val currentQ = questions(i)
      var currentBrainPower = 0

      if (currentBrainPower + currentQ(0) < currentQ(1)) {
        
      }


      println(questions(i).mkString("Array(", ", ", ")"))
    }

    10
  }
}

package com.kylexu.leetcode.array

/**
 * 输入： events = [[1,2],[2,5],[3,9],[1,15]]
 * 输出： 1
 *
 * 解释：
 *
 * 下标为 1 的按钮在时间 2 被按下。
 * 下标为 2 的按钮在时间 5 被按下，因此按下时间为 5 - 2 = 3。
 * 下标为 3 的按钮在时间 9 被按下，因此按下时间为 9 - 5 = 4。
 * 下标为 1 的按钮再次在时间 15 被按下，因此按下时间为 15 - 9 = 6。
 * 最终，下标为 1 的按钮按下时间最长，为 6。
 *
 * 示例 2：
 *
 * 输入： events = [[10,5],[1,7]]
 *
 * 返回按下时间 最长 的按钮的 index。如果有多个按钮的按下时间相同，则返回 index 最小的按钮。
 */
object Solution3386 {
  def main(args: Array[String]): Unit = {
    //    val events = Array(
    //      Array(1, 2),
    //      Array(2, 5),
    //      Array(3, 9),
    //      Array(1, 15)
    //    )

    val events = Array(
      Array(10, 5),
      Array(1, 7)
    )
    val rs = Solution3386.buttonWithLongestTime(events)
    println(rs)
  }

  def buttonWithLongestTime(events: Array[Array[Int]]): Int = {

    var index = Integer.MAX_VALUE
    var gap = 0

    for (elem <- events.indices.reverse) {
      val current = events(elem)
      val currentCost = if (elem == 0) {
        current(1) - 0
      } else {
        current(1) - events(elem - 1)(1)
      }

      if (currentCost > gap) {
        gap = currentCost
        index = events(elem)(0)
      } else if (currentCost == gap) {
        index = Math.min(index, events(elem)(0))
      }
    }

    index
  }
}

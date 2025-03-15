package com.kylexu.leetcode.array

/**
 * 输入：distance = [1,2,3,4], start = 0, destination = 3
 * 输出：4
 * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 *
 * 输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 */
object Solution1184 {
  def main(args: Array[String]): Unit = {
    val distance = Array(7, 10, 1, 12, 11, 14, 5, 0)
    val start = 7
    val destination = 2
    val rs = Solution1184.distanceBetweenBusStops(distance = distance, start = start, destination = destination)
    println(rs)
  }

  def distanceBetweenBusStops(distance: Array[Int], start: Int, destination: Int): Int = {
    val min = Math.min(start, destination)
    val max = Math.max(start, destination)

    var sumForward = 0
    for (i <- min until max) {
      sumForward += distance(i)
    }

    var sumReverse = 0
    for (i <- max until (distance.length + min)) {
      sumReverse += distance(i % distance.length)
    }

    Math.min(sumForward, sumReverse)
  }
}

package com.kylexu.leetcode.num

/**
 * 给你一个正整数 arrivalTime 表示列车正点到站的时间（单位：小时），另给你一个正整数 delayedTime 表示列车延误的小时数。
 * 返回列车实际到站的时间。
 *
 * 注意，该问题中的时间采用 24 小时制。
 *
 * 示例 1：
 *
 * 输入：arrivalTime = 15, delayedTime = 5
 * 输出：20
 * 解释：列车正点到站时间是 15:00 ，延误 5 小时，所以列车实际到站的时间是 15 + 5 = 20（20:00）。
 * 示例 2：
 *
 * 输入：arrivalTime = 13, delayedTime = 11
 * 输出：0
 * 解释：列车正点到站时间是 13:00 ，延误 11 小时，所以列车实际到站的时间是 13 + 11 = 24（在 24 小时制中表示为 00:00 ，所以返回 0）。
 */
object Solution2651 {
  def main(args: Array[String]): Unit = {
    val arrivalTime = 13
    val delayedTime = 11
    val rs = Solution2651.findDelayedArrivalTime(arrivalTime, delayedTime)
    println(rs)
  }

  def findDelayedArrivalTime(arrivalTime: Int, delayedTime: Int): Int = {
    (arrivalTime + delayedTime) % 24
  }
}

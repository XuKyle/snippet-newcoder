package com.kylexu.leetcode.array

import scala.util.boundary
import scala.util.boundary.break

/**
 * 示例 1：
 *
 * 输入：nums = [2,4,1,1,6,5]
 * 输出：3
 * 解释：
 * 在下标 0 ：由于 2 的左侧不存在不相等邻居，所以下标 0 既不是峰也不是谷。
 * 在下标 1 ：4 的最近不相等邻居是 2 和 1 。由于 4 > 2 且 4 > 1 ，下标 1 是一个峰。
 * 在下标 2 ：1 的最近不相等邻居是 4 和 6 。由于 1 < 4 且 1 < 6 ，下标 2 是一个谷。
 * 在下标 3 ：1 的最近不相等邻居是 4 和 6 。由于 1 < 4 且 1 < 6 ，下标 3 符合谷的定义，但需要注意它和下标 2 是同一个谷的一部分。
 * 在下标 4 ：6 的最近不相等邻居是 1 和 5 。由于 6 > 1 且 6 > 5 ，下标 4 是一个峰。
 * 在下标 5 ：由于 5 的右侧不存在不相等邻居，所以下标 5 既不是峰也不是谷。
 * 共有 3 个峰和谷，所以返回 3 。
 * 示例 2：
 *
 * 输入：nums = [6,6,5,5,4,1]
 * 输出：0
 * 解释：
 * 在下标 0 ：由于 6 的左侧不存在不相等邻居，所以下标 0 既不是峰也不是谷。
 * 在下标 1 ：由于 6 的左侧不存在不相等邻居，所以下标 1 既不是峰也不是谷。
 * 在下标 2 ：5 的最近不相等邻居是 6 和 4 。由于 5 < 6 且 5 > 4 ，下标 2 既不是峰也不是谷。
 * 在下标 3 ：5 的最近不相等邻居是 6 和 4 。由于 5 < 6 且 5 > 4 ，下标 3 既不是峰也不是谷。
 * 在下标 4 ：4 的最近不相等邻居是 5 和 1 。由于 4 < 5 且 4 > 1 ，下标 4 既不是峰也不是谷。
 * 在下标 5 ：由于 1 的右侧不存在不相等邻居，所以下标 5 既不是峰也不是谷。
 * 共有 0 个峰和谷，所以返回 0 。
 */
object Solution2210 {
  def main(args: Array[String]): Unit = {
    val nums = Array(2, 4, 1, 1, 6, 5)
    val rs = Solution2210.countHillValley(nums)
    println(rs)
  }

  def countHillValley(nums: Array[Int]): Int = {
    //todo
    var rs = 0

    val n = nums.length
    var before = nums(0)

    for (i <- 1 until n) {
      val current = nums(i)
      var end = i + 1

      boundary:
        while (end < n) {
          if (current == nums(end)) {
            end += 1
          } else {
            break()
          }
        }
      println(s"start= $i ; end = $end")


    }


    0
  }
}

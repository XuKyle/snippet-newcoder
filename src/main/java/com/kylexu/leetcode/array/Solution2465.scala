package com.kylexu.leetcode.array

import scala.collection.mutable

/**
 * 示例 1：
 *
 * 输入：nums = [4,1,4,0,3,5]
 * 输出：2
 * 解释：
 * 1. 删除 0 和 5 ，平均值是 (0 + 5) / 2 = 2.5 ，现在 nums = [4,1,4,3] 。
 * 2. 删除 1 和 4 ，平均值是 (1 + 4) / 2 = 2.5 ，现在 nums = [4,3] 。
 * 3. 删除 3 和 4 ，平均值是 (3 + 4) / 2 = 3.5 。
 * 2.5 ，2.5 和 3.5 之中总共有 2 个不同的数，我们返回 2 。
 * 示例 2：
 *
 * 输入：nums = [1,100]
 * 输出：1
 * 解释：
 * 删除 1 和 100 后只有一个平均值，所以我们返回 1 。
 */
object Solution2465 {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 100)
    val rs = Solution2465.distinctAverages(nums)
    println(rs)
  }

  def distinctAverages(nums: Array[Int]): Int = {
    val rs = mutable.HashSet[Double]()
    val copy = mutable.ArrayBuffer[Int](nums *)


    while (copy.nonEmpty) {
      val max = copy.max(Ordering.Int)
      val min = copy.min(Ordering.Int)

      rs += ((max + min) / 2.0)
      copy.remove(copy.indexWhere(_ == max))
      copy.remove(copy.indexWhere(_ == min))
    }

    rs.size
  }
}

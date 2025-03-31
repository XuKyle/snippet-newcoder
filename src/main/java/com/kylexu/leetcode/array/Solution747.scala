package com.kylexu.leetcode.array

/**
 * 示例 1：
 *
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 至少是数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 */
object Solution747 {
  def main(args: Array[String]): Unit = {
    val nums = Array(3, 6, 1, 0)
    val rs = Solution747.dominantIndex(nums)
    println(rs)
  }

  def dominantIndex(nums: Array[Int]): Int = {
    val sorter = nums.sortWith(_ > _)

    val rs = if (sorter(0) >= 2 * sorter(1)) {
      nums.zipWithIndex.find((elem, index) => elem == sorter(0)).get._2
    } else {
      -1
    }

    rs
  }
}

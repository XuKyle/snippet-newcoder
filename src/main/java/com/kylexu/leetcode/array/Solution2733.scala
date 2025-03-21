package com.kylexu.leetcode.array

import scala.util.boundary
import scala.util.boundary.break

/**
 * 示例 1：
 *
 * 输入：nums = [3,2,1,4]
 * 输出：2
 * 解释：在这个示例中，最小值是 1 ，最大值是 4 。因此，2 或 3 都是有效答案。
 * 示例 2：
 *
 * 输入：nums = [1,2]
 * 输出：-1
 * 解释：由于不存在既不是最大值也不是最小值的数字，我们无法选出满足题目给定条件的数字。因此，不存在答案，返回 -1 。
 * 示例 3：
 *
 * 输入：nums = [2,1,3]
 * 输出：2
 * 解释：2 既不是最小值，也不是最大值，这个示例只有这一个有效答案。
 */
object Solution2733 {
  def main(args: Array[String]): Unit = {
    val nums = Array(2, 1, 3)
    val rs = Solution2733.findNonMinOrMax(nums)
    println(rs)
  }


  def findNonMinOrMax(nums: Array[Int]): Int = {
    if (nums.length <= 2) {
      return -1
    }

    val max = Math.max(nums(0), Math.max(nums(1), nums(2)))
    val min = Math.min(nums(0), Math.min(nums(1), nums(2)))

    val rs = boundary:
      for (i <- 0 until 3) {
        if (nums(i) != max && nums(i) != min) {
          break(nums(i))
        }
      }
      -1

    rs
  }
}


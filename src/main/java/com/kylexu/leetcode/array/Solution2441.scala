package com.kylexu.leetcode.array

import scala.util.boundary
import scala.util.boundary.{Break, break}
import scala.util.control.Breaks

/**
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 * 示例 2：
 *
 * 输入：nums = [-1,10,6,7,-7,1]
 * 输出：7
 * 解释：数组中存在 1 和 7 对应的负数，7 的值更大。
 * 示例 3：
 *
 * 输入：nums = [-10,8,6,7,-2,-3]
 * 输出：-1
 * 解释：不存在满足题目要求的 k ，返回 -1 。
 */
object Solution2441 {
  def main(args: Array[String]): Unit = {
    val nums = Array(-10, 8, 6, 7, -2, -3)
    val rs = Solution2441.findMaxK(nums)
    println(rs)
  }

  def findMaxK(nums: Array[Int]): Int = {
    val sorter = nums.sortWith(_ > _)
    val inner = new Breaks

    val rs = boundary:
      for (i <- sorter.indices) {
        inner.breakable {
          for (j <- sorter.indices.reverse) {
            if (sorter(i) + sorter(j) == 0) {
              break(sorter(i))
            } else if (sorter(i) + sorter(j) > 0) {
              inner.break()
            }
          }
        }
      }
      -1

    rs
  }
}

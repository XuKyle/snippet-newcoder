package com.kylexu.leetcode.array

/**
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5]
 *
 * 输出：15
 *
 * 解释：
 *
 * 不删除任何元素，选中整个数组得到最大元素和。
 *
 * 示例 2：
 *
 * 输入：nums = [1,1,0,1,1]
 *
 * 输出：1
 *
 * 解释：
 *
 * 删除元素 nums[0] == 1、nums[1] == 1、nums[2] == 0 和 nums[3] == 1 。选中整个数组 [1] 得到最大元素和。
 *
 * 示例 3：
 *
 * 输入：nums = [1,2,-1,-2,1,0,-1]
 *
 * 输出：3
 *
 * 解释：
 *
 * 删除元素 nums[2] == -1 和 nums[3] == -2 ，从 [1, 2, 1, 0, -1] 中选中子数组 [2, 1] 以获得最大元素和。
 */
object Solution3487 {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, -1, -2, 1, 0, -1)
    val rs = Solution3487.maxSum(nums)
    println(rs)
  }

  def maxSum(nums: Array[Int]): Int = {
    val rs = nums.filter(_ > 0).distinct
    if (rs.length == 0) nums.max else rs.sum
  }
}

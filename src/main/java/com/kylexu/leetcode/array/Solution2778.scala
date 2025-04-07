package com.kylexu.leetcode.array

/**
 * 输入：nums = [1,2,3,4]
 * 输出：21
 * 解释：nums 中共有 3 个特殊元素：nums[1]，因为 4 被 1 整除；nums[2]，因为 4 被 2 整除；以及 nums[4]，因为 4 被 4 整除。
 * 因此，nums 中所有特殊元素的平方和等于 nums[1] * nums[1] + nums[2] * nums[2] + nums[4] * nums[4] = 1 * 1 + 2 * 2 + 4 * 4 = 21 。
 * 示例 2：
 *
 * 输入：nums = [2,7,1,19,18,3]
 * 输出：63
 * 解释：nums 中共有 4 个特殊元素：nums[1]，因为 6 被 1 整除；nums[2] ，因为 6 被 2 整除；nums[3]，因为 6 被 3 整除；以及 nums[6]，因为 6 被 6 整除。
 * 因此，nums 中所有特殊元素的平方和等于 nums[1] * nums[1] + nums[2] * nums[2] + nums[3] * nums[3] + nums[6] * nums[6] = 2 * 2 + 7 * 7 + 1 * 1 + 3 * 3 = 63
 */
object Solution2778 {
  def main(args: Array[String]): Unit = {
    val nums = Array(2, 7, 1, 19, 18, 3)
    val rs = Solution2778.sumOfSquares(nums)
    println(rs)
  }

  def sumOfSquares(nums: Array[Int]): Int = {
    val n = nums.length
    nums.zipWithIndex
      .filter((elem, index) => n % (index + 1) == 0)
      .map(elem => elem._1 * elem._1)
      .sum
  }
}

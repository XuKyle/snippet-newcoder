package com.kylexu.leetcode.array

/**
 * 输入： nums = [3,9,7], k = 5
 * 输出： 4
 * 解释：
 * 对 nums[1] = 9 执行 4 次操作。现在 nums = [3, 5, 7]。
 * 数组之和为 15，可以被 5 整除。
 * 示例 2：
 *
 * 输入： nums = [4,1,3], k = 4
 * 输出： 0
 * 解释：
 *
 * 数组之和为 8，已经可以被 4 整除。因此不需要操作。
 * 示例 3：
 *
 * 输入： nums = [3,2], k = 6
 *
 * 输出： 5
 *
 * 解释：
 *
 * 对 nums[0] = 3 执行 3 次操作，对 nums[1] = 2 执行 2 次操作。现在 nums = [0, 0]。
 * 数组之和为 0，可以被 6 整除。
 */
object Solution3512 {
  def main(args: Array[String]): Unit = {
    val nums = Array(3, 9, 7)
    val k = 5
    val rs = Solution3512.minOperations(nums = nums, k = k)
    println(rs)
  }

  def minOperations(nums: Array[Int], k: Int): Int = {
    nums.sum % k
  }
}

package com.kylexu.leetcode.array

/**
 * 示例 1：
 *
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以进行如下操作：
 * 1) 增加 nums[2] ，数组变为 [1,1,2] 。
 * 2) 增加 nums[1] ，数组变为 [1,2,2] 。
 * 3) 增加 nums[2] ，数组变为 [1,2,3] 。
 * 示例 2：
 *
 * 输入：nums = [1,5,2,4,1]
 * 输出：14
 * 示例 3：
 *
 * 输入：nums = [8]
 * 输出：0
 */
object Solution1827 {
  def main(args: Array[String]): Unit = {
    val nums = Array(8)
    val rs = Solution1827.minOperations(nums)
    println(rs)
  }

  def minOperations(nums: Array[Int]): Int = {
    if (nums.length <= 1) {
      return 0
    }

    var rs = 0
    var pre = nums(0)

    for (i <- 1 until nums.length) {
      val current = nums(i)
      if (current <= pre) {
        rs += (pre + 1 - current)
        pre = pre + 1
      } else {
        pre = current
      }
    }

    rs
  }
}

package com.kylexu.leetcode.array

/**
 * 输入：nums = [12,6,1,2,7]
 * 输出：77
 * 解释：下标三元组 (0, 2, 4) 的值是 (nums[0] - nums[2]) * nums[4] = 77 。
 * 可以证明不存在值大于 77 的有序下标三元组。
 * 示例 2：
 *
 * 输入：nums = [1,10,3,4,19]
 * 输出：133
 * 解释：下标三元组 (1, 2, 4) 的值是 (nums[1] - nums[2]) * nums[4] = 133 。
 * 可以证明不存在值大于 133 的有序下标三元组。
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：唯一的下标三元组 (0, 1, 2) 的值是一个负数，(nums[0] - nums[1]) * nums[2] = -3 。因此，答案是 0 。
 */
object Solution2873 {
  def main(args: Array[String]): Unit = {
    val nums = Array(1000000, 1, 1000000)
    val rs = Solution2873.maximumTripletValue(nums)
    println(rs)
  }

  def maximumTripletValue(nums: Array[Int]): Long = {
    var rs = Long.MinValue

    for (i <- nums.indices) {
      for (j <- i + 1 until nums.length) {
        for (k <- j + 1 until nums.length) {
          rs = math.max(rs, (nums(i).toLong - nums(j)) * nums(k))
        }
      }
    }


    if (rs < 0) 0 else rs
  }
}

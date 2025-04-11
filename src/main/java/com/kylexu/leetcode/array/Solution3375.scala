package com.kylexu.leetcode.array

/**
 * 输入：nums = [5,2,5,4,5], k = 2
 * 输出：2
 * 解释：
 * 依次选择合法整数 4 和 2 ，将数组全部变为 2 。
 * 示例 2：
 * 输入：nums = [2,1,2], k = 2
 * 输出：-1
 * 示例 3：
 * 输入：nums = [9,7,5,3], k = 1
 * 输出：4
 * 解释：
 *
 * 依次选择合法整数 7 ，5 ，3 和 1 ，将数组全部变为 1 。
 */
object Solution3375 {
  def main(args: Array[String]): Unit = {
    val num = Array(9, 7, 5, 3)
    val k = 1
    val rs = Solution3375.minOperations(num, k)
    println(rs)
  }

  def minOperations(nums: Array[Int], k: Int): Int = {
    val lessCount = nums.count(_ < k)
    if (lessCount > 0) {
      return -1
    }

    nums.distinct.count(_ > k)
  }
}

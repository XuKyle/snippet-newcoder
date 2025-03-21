package com.kylexu.leetcode.array

/**
 * 输入：nums = [1,0,0,0,1,0,0,1], k = 2
 * 输出：true
 * 解释：每个 1 都至少相隔 2 个元素。
 * 示例 2：
 *
 * 输入：nums = [1,0,0,1,0,1], k = 2
 * 输出：false
 * 解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
 */
object Solution1437 {
  def main(args: Array[String]): Unit = {
    val nums = Array(0, 0, 0)
    val k = 2
    val rs = Solution1437.kLengthApart(nums, k)
    println(rs)
  }

  def kLengthApart(nums: Array[Int], k: Int): Boolean = {
    val rs = nums.zipWithIndex.filter((elem, index) => elem == 1).map(_._2).toList
    if (rs.isEmpty) {
      return true
    }
    rs.zip(rs.tail).forall {
      (pre, next) => next - pre - 1 >= k
    }
  }
}


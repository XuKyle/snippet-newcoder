package com.kylexu.leetcode.array

/**
 * 示例 1:
 *
 * 输入：nums = [4,3,2,1]
 *
 * 输出：[0,0,1,1]
 *
 * 解释：
 *
 * 将偶数（4 和 2）替换为 0，将奇数（3 和 1）替换为 1。现在，nums = [0, 1, 0, 1]。
 * 按非递减顺序排序 nums，得到 nums = [0, 0, 1, 1]。
 * 示例 2:
 *
 * 输入：nums = [1,5,1,4,2]
 *
 * 输出：[0,0,1,1,1]
 *
 * 解释：
 *
 * 将偶数（4 和 2）替换为 0，将奇数（1, 5 和 1）替换为 1。现在，nums = [1, 1, 1, 0, 0]。
 * 按非递减顺序排序 nums，得到 nums = [0, 0, 1, 1, 1]。
 */
object Solution3467 {
  def main(args: Array[String]): Unit = {
    val nums = Array(4, 3, 2, 1)
    val rs = Solution3467.transformArray(nums)
    println(rs.mkString("Array(", ", ", ")"))
  }

  def transformArray(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val m = nums.count(it => it % 2 == 0)
    Array.fill(m)(0) ++ Array.fill(n - m)(1)
  }
}

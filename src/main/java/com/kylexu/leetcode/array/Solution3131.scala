package com.kylexu.leetcode.array

/**
 * 示例 1:
 *
 * 输入：nums1 = [2,6,4], nums2 = [9,7,5]
 *
 * 输出：3
 *
 * 解释：
 *
 * 与 3 相加后，nums1 和 nums2 相等。
 *
 * 示例 2:
 *
 * 输入：nums1 = [10], nums2 = [5]
 *
 * 输出：-5
 *
 * 解释：
 *
 * 与 -5 相加后，nums1 和 nums2 相等。
 *
 * 示例 3:
 *
 * 输入：nums1 = [1,1,1,1], nums2 = [1,1,1,1]
 *
 * 输出：0
 *
 * 解释：
 *
 * 与 0 相加后，nums1 和 nums2 相等。
 */
object Solution3131 {
  def main(args: Array[String]): Unit = {
    val num1 = Array(2, 6, 4)
    val num2 = Array(9, 7, 5)
    val rs = Solution3131.addedInteger(num1, num2)
    println(rs)
  }

  def addedInteger(nums1: Array[Int], nums2: Array[Int]): Int = {
    -1 * (nums1.sum / nums1.length - nums2.sum / nums2.length)
  }
}

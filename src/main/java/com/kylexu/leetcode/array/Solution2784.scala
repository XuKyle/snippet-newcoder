package com.kylexu.leetcode.array

import scala.util.boundary
import scala.util.boundary.break

/**
 * 输入：nums = [2, 1, 3]
 * 输出：false
 * 解释：因为数组的最大元素是 3 ，唯一可以构成这个数组的 base[n] 对应的 n = 3 。但是 base[3] 有 4 个元素，但数组 nums 只有 3 个元素，所以无法得到 base[3] = [1, 2, 3, 3] 的排列，所以答案为 false 。
 * 示例 2：
 *
 * 输入：nums = [1, 3, 3, 2]
 * 输出：true
 * 解释：因为数组的最大元素是 3 ，唯一可以构成这个数组的 base[n] 对应的 n = 3 ，可以看出数组是 base[3] = [1, 2, 3, 3] 的一个排列（交换 nums 中第二个和第四个元素）。所以答案为 true 。
 * 示例 3：
 *
 * 输入：nums = [1, 1]
 * 输出：true
 * 解释：因为数组的最大元素是 1 ，唯一可以构成这个数组的 base[n] 对应的 n = 1，可以看出数组是 base[1] = [1, 1] 的一个排列。所以答案为 true 。
 * 示例 4：
 *
 * 输入：nums = [3, 4, 4, 1, 2, 1]
 * 输出：false
 * 解释：因为数组的最大元素是 4 ，唯一可以构成这个数组的 base[n] 对应的 n = 4 。但是 base[n] 有 5 个元素而 nums 有 6 个元素。所以答案为 false 。
 */
object Solution2784 {
  def isGood(nums: Array[Int]): Boolean = {
    val max = nums.max
    val counter = nums.groupBy(identity).map((item, arr) => (item, arr.length))

    val rs = boundary:
      for (i <- 1 to max) {
        if (i != max) {
          if (counter.getOrElse(i, -1) != 1) {
            break(false)
          }
        } else {
          break(counter(i) == 2)
        }
      }
      true

    rs
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(2, 1, 3)
    val rs = Solution2784.isGood(nums)
    println(rs)
  }
}

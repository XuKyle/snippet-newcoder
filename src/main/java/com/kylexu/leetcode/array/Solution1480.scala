package com.kylexu.leetcode.array

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 */
object Solution1480 {
  def main(args: Array[String]): Unit = {
    val nums = Array(3, 1, 2, 10, 1)
    val rs = Solution1480.runningSum(nums)
    println(rs.mkString("Array(", ", ", ")"))
  }

  def runningSum(nums: Array[Int]): Array[Int] = {
    //    var sum = 0
    //
    //    for (i <- nums.indices) {
    //      sum += nums(i)
    //      nums(i) = sum
    //    }
    //
    //    nums



    nums.scanLeft(0)(_ + _).tail
  }
}

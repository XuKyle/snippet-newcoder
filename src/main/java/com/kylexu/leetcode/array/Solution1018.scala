package com.kylexu.leetcode.array

/**
 * 示例 1：
 * 输入：nums = [0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为 true 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：[false,false,false]
 */
object Solution1018 {
  def prefixesDivBy5(nums: Array[Int]): List[Boolean] = {
    var current = BigInt.apply(0)
    var rs = List.empty[Boolean]

    for (elem <- nums) {
      current = (current * 2 + elem)
      rs :+= current % 5 == 0
    }
    rs
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0)
    val rs = Solution1018.prefixesDivBy5(nums)
    println(rs)
  }
}

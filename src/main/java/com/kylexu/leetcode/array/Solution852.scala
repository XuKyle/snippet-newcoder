package com.kylexu.leetcode.array

/**
 * 给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
 * 返回峰值元素的下标。
 * 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
 *
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 *
 * 输入：arr = [0,10,5,2]
 * 输出：1
 */
object Solution852 {
  def main(args: Array[String]): Unit = {
    val arr = Array(0, 2, 7, 8, 9, 10, 9, 7)
    //    val arr = Array(3, 5, 3, 2, 0)
    val rs = Solution852.peakIndexInMountainArray(arr)
    println(rs)
  }

  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    var left = 0
    var right = arr.length - 1

    while (left < right - 1) {
      val mid = left + (right - left) / 2;
      if (arr(mid) > arr(mid + 1)) {
        right = mid
      } else {
        left = mid
      }
    }
    right
  }
}

package com.kylexu.leetcode.array

import scala.util.boundary
import scala.util.boundary.break
import scala.util.control.Breaks.breakable

/**
 * 给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
 * 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
 *
 * 示例 1：
 * 输入：target = [1,2,3,4], arr = [2,4,1,3]
 * 输出：true
 * 解释：你可以按照如下步骤使 arr 变成 target：
 * 1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
 * 2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
 * 3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
 * 上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
 * 示例 2：
 *
 * 输入：target = [7], arr = [7]
 * 输出：true
 * 解释：arr 不需要做任何翻转已经与 target 相等。
 * 示例 3：
 *
 * 输入：target = [3,7,9], arr = [3,7,11]
 * 输出：false
 * 解释：arr 没有数字 9 ，所以无论如何也无法变成 target 。
 */
object Solution1460 {
  def main(args: Array[String]): Unit = {
    //    val target = Array(1, 2, 2, 3)
    //    val arr = Array(1, 1, 2, 3)

    val target = Array(1, 2, 3, 4)
    val arr = Array(2, 4, 1, 3)
    val rs = Solution1460.canBeEqual(target, arr)
    println(rs)
  }

  def canBeEqual(target: Array[Int], arr: Array[Int]): Boolean = {
    val rs = boundary:
      for (i <- target.indices) {
        val lastIndex = arr.zipWithIndex.filter((elem, index) => index >= i).find((elem, index) => elem == target(i)).getOrElse((-1, -1))._2
        if (lastIndex == -1) {
          break(false)
        }
        if (i != lastIndex) {
          //          println(s"before: i = $i; lastIndex = $lastIndex; arr ${arr.mkString("Array(", ", ", ")")}")
          swap(arr, i, lastIndex)
          //          println(s"after: arr ${arr.mkString("Array(", ", ", ")")}")
        }
      }
      true

    rs
  }

  def swap(arr: Array[Int], start: Int, end: Int): Unit = {
    var left = start
    var right = end
    while (left <= right) {
      val temp = arr(left)
      arr(left) = arr(right)
      arr(right) = temp

      left += 1
      right -= 1
    }
  }
}

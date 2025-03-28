package com.kylexu.leetcode.array

import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * 示例 1：
 *
 * 输入：arr = [1,2,4,4,4,4], m = 1, k = 3
 * 输出：true
 * 解释：模式 (4) 的长度为 1 ，且连续重复 4 次。注意，模式可以重复 k 次或更多次，但不能少于 k 次。
 * 示例 2：
 *
 * 输入：arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
 * 输出：true
 * 解释：模式 (1,2) 长度为 2 ，且连续重复 2 次。另一个符合题意的模式是 (2,1) ，同样重复 2 次。
 * 示例 3：
 *
 * 输入：arr = [1,2,1,2,1,3], m = 2, k = 3
 * 输出：false
 * 解释：模式 (1,2) 长度为 2 ，但是只连续重复 2 次。不存在长度为 2 且至少重复 3 次的模式。
 * 示例 4：
 *
 * 输入：arr = [1,2,3,1,2], m = 2, k = 2
 * 输出：false
 * 解释：模式 (1,2) 出现 2 次但并不连续，所以不能算作连续重复 2 次。
 * 示例 5：
 *
 * 输入：arr = [2,2,2,2], m = 2, k = 3
 * 输出：false
 * 解释：长度为 2 的模式只有 (2,2) ，但是只连续重复 2 次。注意，不能计算重叠的重复次数。
 *
 */
object Solution1566 {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 4, 4, 4, 4)
    val m = 1
    val k = 4
    val rs = Solution1566.containsPattern(arr = arr, m = m, k = k)
    println(rs)
  }

  def containsPattern(arr: Array[Int], m: Int, k: Int): Boolean = {
    val arrStr = arr.mkString("")

    val rs = boundary:
      for (i <- arr.indices if i < arr.length - m) {
        val currentStr: String = arr.slice(i, arr.length).mkString("")
        val currentPattern = arr.slice(i, i + m).mkString("")

        val patterns = mutable.ListBuffer[String]()
        for (j <- Range(0, currentStr.length, m)) {
          val start = j
          val end = Math.min(j + m, currentStr.length)
          patterns.append(currentStr.substring(start, end))
        }

        //        println(s"pattern: $patterns")

        var count = 0
        val innerRs = boundary:
          for (elem <- patterns) {
            if (currentPattern.equals(elem)) {
              count += 1
              if (count >= k) {
                break(true)
              }
            } else {
              if (count >= k) {
                break(true)
              } else {
                break(false)
              }
            }
          }
          false

        //        println(s"counter: $count")

        if (innerRs) {
          break(true)
        }
      }
      false

    rs
  }
}

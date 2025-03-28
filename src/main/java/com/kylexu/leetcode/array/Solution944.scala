package com.kylexu.leetcode.array

import scala.util.boundary
import scala.util.boundary.break

/**
 * 示例 1：
 *
 * 输入：strs = ["cba","daf","ghi"]
 * 输出：1
 * 解释：网格示意如下：
 * cba
 * daf
 * ghi
 * 列 0 和列 2 按升序排列，但列 1 不是，所以只需要删除列 1 。
 * 示例 2：
 *
 * 输入：strs = ["a","b"]
 * 输出：0
 * 解释：网格示意如下：
 * a
 * b
 * 只有列 0 这一列，且已经按升序排列，所以不用删除任何列。
 * 示例 3：
 *
 * 输入：strs = ["zyx","wvu","tsr"]
 * 输出：3
 * 解释：网格示意如下：
 * zyx
 * wvu
 * tsr
 * 所有 3 列都是非升序排列的，所以都要删除。
 */
object Solution944 {
  def main(args: Array[String]): Unit = {
    val strs = Array("zyx", "wvu", "tsr")
    val rs = Solution944.minDeletionSize(strs)
    println(rs)
  }

  def minDeletionSize(strs: Array[String]): Int = {
    val n = strs(0).length

    var rs = 0
    for (i <- 0 until n) {
      var preChar = 'a' - 1
      val flag = boundary:
        for (elem <- strs) {
          if (elem.charAt(i) < preChar) {
            break(false)
          } else {
            preChar = elem.charAt(i)
          }
        }
        true
      if (!flag) {
        rs += 1
      }
    }
    rs
  }
}

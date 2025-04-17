package com.kylexu.leetcode.num

/**
 * 示例 1：
 *
 * 输入： x = 2, y = 7, z = 4
 *
 * 输出： 1
 *
 * 解释：
 *
 * 第 1 个人在位置 2，到达第 3 个人（位置 4）需要 2 步。
 * 第 2 个人在位置 7，到达第 3 个人需要 3 步。
 * 由于第 1 个人先到达，所以输出为 1。
 *
 * 示例 2：
 *
 * 输入： x = 2, y = 5, z = 6
 *
 * 输出： 2
 *
 * 解释：
 *
 * 第 1 个人在位置 2，到达第 3 个人（位置 6）需要 4 步。
 * 第 2 个人在位置 5，到达第 3 个人需要 1 步。
 * 由于第 2 个人先到达，所以输出为 2。
 *
 * 示例 3：
 *
 * 输入： x = 1, y = 5, z = 3
 *
 * 输出： 0
 *
 * 解释：
 *
 * 第 1 个人在位置 1，到达第 3 个人（位置 3）需要 2 步。
 * 第 2 个人在位置 5，到达第 3 个人需要 2 步。
 * 由于两个人同时到达，所以输出为 0。
 */
object Solution3516 {
  def main(args: Array[String]): Unit = {
    val x = 1
    val y = 5
    val z = 3
    val rs = Solution3516.findClosest(x = x, y = y, z = z)
    println(rs)
  }

  /**
   * 如果第 1 个人先到达，返回 1 。
   * 如果第 2 个人先到达，返回 2 。
   * 如果两个人同时到达，返回 0 。
   */
  def findClosest(x: Int, y: Int, z: Int): Int = {
    val gap1 = Math.abs(x - z)
    val gap2 = Math.abs(y - z)

    val rs = if (gap1 == gap2) {
      0
    } else if (gap1 < gap2) {
      1
    } else {
      2
    }

    rs
  }
}

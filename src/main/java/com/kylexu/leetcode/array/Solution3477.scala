package com.kylexu.leetcode.array

import scala.collection.mutable
import scala.util.control.Breaks

/**
 * 示例 1
 *
 * 输入： fruits = [4,2,5], baskets = [3,5,4]
 * 输出： 1
 * 解释：
 *
 * fruits[0] = 4 放入 baskets[1] = 5。
 * fruits[1] = 2 放入 baskets[0] = 3。
 * fruits[2] = 5 无法放入 baskets[2] = 4。
 * 由于有一种水果未放置，我们返回 1。
 *
 * 示例 2
 *
 * 输入： fruits = [3,6,1], baskets = [6,4,7]
 * 输出： 0
 * 解释：
 *
 * fruits[0] = 3 放入 baskets[0] = 6。
 * fruits[1] = 6 无法放入 baskets[1] = 4（容量不足），但可以放入下一个可用的篮子 baskets[2] = 7。
 * fruits[2] = 1 放入 baskets[1] = 4。
 * 由于所有水果都已成功放置，我们返回 0。
 */
object Solution3477 {
  def main(args: Array[String]): Unit = {
    val fruits = Array(4, 2, 5)
    val baskets = Array(3, 5, 4)
    val rs = Solution3477.numOfUnplacedFruits(fruits, baskets)
    println(rs)
  }

  def numOfUnplacedFruits(fruits: Array[Int], baskets: Array[Int]): Int = {
    val used = mutable.HashSet[Int]()
    val inner = new Breaks

    for (elem <- fruits) {
      inner.breakable {
        for (j <- baskets.indices) {
          if (elem <= baskets(j) && !used.contains(j)) {
            used += j
            inner.break()
          }
        }
      }
    }

    fruits.length - used.size
  }
}

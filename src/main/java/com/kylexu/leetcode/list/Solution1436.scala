package com.kylexu.leetcode.list

import scala.collection.mutable

/**
 * 示例 1：
 *
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 * 示例 2：
 *
 * 输入：paths = [["B","C"],["D","B"],["C","A"]]
 * 输出："A"
 * 解释：所有可能的线路是：
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * 显然，旅行终点站是 "A" 。
 * 示例 3：
 *
 * 输入：paths = [["A","Z"]]
 * 输出："Z"
 */
object Solution1436 {
  def main(args: Array[String]): Unit = {
    val paths = List(
      List("London", "New York"),
      List("New York", "Lima"),
      List("Lima", "Sao Paulo")
    )

    val rs = Solution1436.destCity(paths)
    println(rs)
  }

  def destCity(paths: List[List[String]]): String = {
    val leave = mutable.Set[String]()
    val arrive = mutable.Set[String]()

    for (elem <- paths) {
      leave += elem.head
      arrive += elem(1)
    }

    arrive.subtractAll(leave).head
  }
}

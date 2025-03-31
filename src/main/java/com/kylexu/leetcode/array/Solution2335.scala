package com.kylexu.leetcode.array

/**
 * 示例 1：
 *
 * 输入：amount = [1,4,2]
 * 输出：4
 * 解释：下面给出一种方案：
 * 第 1 秒：装满一杯冷水和一杯温水。
 * 第 2 秒：装满一杯温水和一杯热水。
 * 第 3 秒：装满一杯温水和一杯热水。
 * 第 4 秒：装满一杯温水。
 * 可以证明最少需要 4 秒才能装满所有杯子。
 * 示例 2：
 *
 * 输入：amount = [5,4,4]
 * 输出：7
 * 解释：下面给出一种方案：
 * 第 1 秒：装满一杯冷水和一杯热水。
 * 第 2 秒：装满一杯冷水和一杯温水。
 * 第 3 秒：装满一杯冷水和一杯温水。
 * 第 4 秒：装满一杯温水和一杯热水。
 * 第 5 秒：装满一杯冷水和一杯热水。
 * 第 6 秒：装满一杯冷水和一杯温水。
 * 第 7 秒：装满一杯热水。
 * 示例 3：
 *
 * 输入：amount = [5,0,0]
 * 输出：5
 * 解释：每秒装满一杯冷水。
 */
object Solution2335 {
  def main(args: Array[String]): Unit = {
    val amount = Array(1, 4, 2)
    val rs = Solution2335.fillCups(amount)
    println(rs)
  }

  def fillCups(amount: Array[Int]): Int = {
    var rs = 0
    var temp = amount.sortWith(_ > _)

    while (temp(1) != 0) {
      temp(0) -= 1
      temp(1) -= 1
      rs += 1
      temp = temp.sortWith(_ > _)
    }

    rs += temp(0)

    rs
  }
}

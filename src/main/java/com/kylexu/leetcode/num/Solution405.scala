package com.kylexu.leetcode.num

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * 答案字符串中的所有字母都应该是小写字符，并且除了 0 本身之外，答案中不应该有任何前置零。
 *
 * 注意: 不允许使用任何由库提供的将数字直接转换或格式化为十六进制的方法来解决这个问题。
 *
 * 示例 1：
 *
 * 输入：num = 26
 * 输出："1a"
 * 示例 2：
 *
 * 输入：num = -1
 * 输出："ffffffff"
 */
object Solution405 {
  def toHex(num: Int): String = {
    if (num == 0) {
      return "0"
    }
    val mark = Array("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f")

    val flag = num < 0

    var currentNum: Long = if (flag) (Math.pow(2, 32) + num).toLong else num
    val rs = new StringBuilder()

    while (currentNum != 0) {
      val index = currentNum % 16
      rs.append(mark(index.toInt))
      currentNum = currentNum / 16
    }

    rs.reverse.toString()
  }

  def main(args: Array[String]): Unit = {
    val num = -1
    val rs = Solution405.toHex(num)
    println(rs)
  }
}

package com.kylexu.leetcode.str

import scala.collection.mutable

/**
 * 示例 1：
 * 输入：s = "l|*e*et|c**o|*de|"
 * 输出：2
 * 解释：不在竖线对之间的字符加粗加斜体后，得到字符串："l|*e*et|c**o|*de|" 。
 * 第一和第二条竖线 '|' 之间的字符不计入答案。
 * 同时，第三条和第四条竖线 '|' 之间的字符也不计入答案。
 * 不在竖线对之间总共有 2 个星号，所以我们返回 2 。
 * 示例 2：
 *
 * 输入：s = "iamprogrammer"
 * 输出：0
 * 解释：在这个例子中，s 中没有星号。所以返回 0 。
 * 示例 3：
 *
 * 输入：s = "yo|uar|e**|b|e***au|tifu|l"
 * 输出：5
 * 解释：需要考虑的字符加粗加斜体后："yo|uar|e**|b|e***au|tifu|l" 。不在竖线对之间总共有 5 个星号。所以我们返回 5 。
 */
object Solution2315 {
  def main(args: Array[String]): Unit = {
    val s = "*jsaxclgfcyjds"
    val rs = Solution2315.countAsterisks(s)
    println(rs)
  }

  def countAsterisks(s: String): Int = {

    val index = mutable.ListBuffer[Int]()
    for (i <- 0 until s.length) {
      if (s.charAt(i) == '|') {
        index += i
      }
    }

    var rs = 0
    if (index.isEmpty) {
      return s.length - s.replaceAll("\\*", "").length
    }
    if (index.nonEmpty) {
      val first = s.substring(0, index.head)
      rs += first.length - first.replaceAll("\\*", "").length
    }

    for (i <- Range(1, index.length, 2)) {
      val start = index(i)
      val end = if (i == index.length - 1) s.length else index(i + 1) + 1

      val current = s.substring(start, end)
      //      println(s"start = $start;end = $end;current = $current")
      rs += current.length - current.replaceAll("\\*", "").length
    }

    rs
  }
}

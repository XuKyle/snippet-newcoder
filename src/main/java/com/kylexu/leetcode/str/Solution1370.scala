package com.kylexu.leetcode.str

import scala.collection.mutable

/**
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出比上一个添加字符更大的 最小 字符，将它 接在 结果字符串后面。
 *
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出比上一个添加字符更小的 最大 字符，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 *
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 */
object Solution1370 {
  def main(args: Array[String]): Unit = {
    val s = "rat"
    val rs = Solution1370.sortString(s)
    println(rs)
  }

  def sortString(s: String): String = {
    val counter = s.toCharArray.map(_.toString).groupBy(identity).view.mapValues(_.length).to(mutable.Map)
    val sorter = s.toCharArray.map(_.toString).distinct.sortWith(_ < _).toList

    val rs = new StringBuilder()
    while (counter.nonEmpty) {
      // 正向循环
      for (elem <- sorter) {
        if (counter.contains(elem)) {
          rs.append(elem)
          counter(elem) -= 1

          if (counter(elem) == 0) {
            counter.remove(elem)
          }
        }

      }
      //      println(s" before : = $rs")
      // 反向循环
      for (elem <- sorter.indices.reverse) {
        if (counter.contains(sorter(elem))) {
          rs.append(sorter(elem))
          counter(sorter(elem)) -= 1

          if (counter(sorter(elem)) == 0) {
            counter.remove(sorter(elem))
          }
        }
      }
      //      println(s" after : = $rs")
    }

    rs.toString()
  }
}

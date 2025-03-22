package com.kylexu.leetcode.array

import scala.collection.mutable

/**
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：words = ["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：words = ["cool","lock","cook"]
 * 输出：["c","o"]
 */
object Solution1002 {
  def commonChars(words: Array[String]): List[String] = {
    val counters = words.map(word =>
      word.toCharArray.groupBy(identity).view.mapValues(_.length).toMap
    )

    counters.reduce { (acc, curr) =>
      acc.map { case (k, v) =>
        curr.get(k).map(c => (k, Math.min(v, c))).getOrElse((k, 0))
      }.filter(_._2 > 0)
    }.flatMap {
      case (k, v) => List.fill(v)(k.toString)
    }.toList
  }

  def main(args: Array[String]): Unit = {
    val words = Array("bella", "label", "roller")
    val rs = Solution1002.commonChars(words)
    println(rs)
  }
}

package com.kylexu.leetcode.array

object Solution3042 {
  def main(args: Array[String]): Unit = {
    val words = Array("a", "aba", "ababa", "aa")
    val rs = Solution3042.countPrefixSuffixPairs(words)
    println(rs)
  }

  def countPrefixSuffixPairs(words: Array[String]): Int = {
    var rs = 0

    for (i <- words.indices) {
      for (j <- i + 1 until words.length) {
        if (isPrefixAndSuffix(words(i), words(j))) {
          rs += 1
        }
      }
    }

    rs
  }

  def isPrefixAndSuffix(str1: String, str2: String): Boolean = {
    str2.startsWith(str1) && str2.endsWith(str1)
  }
}

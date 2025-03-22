package com.kylexu.leetcode.str

/**
 * 示例 1：
 *
 * 输入：s = "xyzzaz"
 * 输出：1
 * 解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
 * 唯一的长度为 3 的好子字符串是 "xyz" 。
 * 示例 2：
 *
 * 输入：s = "aababcabc"
 * 输出：4
 * 解释：总共有 7 个长度为 3 的子字符串："aab"，"aba"，"bab"，"abc"，"bca"，"cab" 和 "abc" 。
 * 好子字符串包括 "abc"，"bca"，"cab" 和 "abc" 。
 */
object Solution1876 {
  def main(args: Array[String]): Unit = {
    val s = "xyzzaz"
    val rs = Solution1876.countGoodSubstrings(s)
    println(rs)
  }

  def countGoodSubstrings(s: String): Int = {
    var rs = 0

    for (i <- 0 to s.length - 3) {
      if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i + 1) != s.charAt(i + 2) && s.charAt(i) != s.charAt(i + 2)) {
        rs += 1
      }
    }

    rs
  }
}

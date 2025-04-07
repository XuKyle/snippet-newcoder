package com.kylexu.leetcode.str

/**
 * 示例 1：
 *
 * 输入： s = "dart", k = 3
 *
 * 输出： "tdar"
 *
 * 解释：
 *
 * 对于 i = 0，'d' 后面的第 3 个字符是 't'。
 * 对于 i = 1，'a' 后面的第 3 个字符是 'd'。
 * 对于 i = 2，'r' 后面的第 3 个字符是 'a'。
 * 对于 i = 3，'t' 后面的第 3 个字符是 'r'。
 * 示例 2：
 *
 * 输入： s = "aaa", k = 1
 *
 * 输出： "aaa"
 *
 * 解释：
 *
 * 由于所有字符都相同，加密后的字符串也将相同。
 */
object Solution3210 {
  def main(args: Array[String]): Unit = {
    val s = "dart"
    val k = 3
    val rs = Solution3210.getEncryptedString(s, k)
    println(rs)
  }

  def getEncryptedString(s: String, k: Int): String = {
    val index = (s.length + k) % s.length
    s.substring(index) + s.substring(0, index)
  }
}

package com.kylexu.leetcode.str

/**
 * 给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
 * 我们想要重新格式化字符串 s，使每一组包含 k 个字符，除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。此外，两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
 * 返回 重新格式化的许可密钥 。
 * 示例 1：
 * 输入：S = "5F3Z-2e-9-w", k = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 * 注意，两个额外的破折号需要删掉。
 * 示例 2：
 *
 * 输入：S = "2-5g-3-J", k = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 */
object Solution482 {
  def main(args: Array[String]): Unit = {
    val s = "5F3Z-2e-9-w"
    val k = 4
    val rs = Solution482.licenseKeyFormatting(s, k)
    println(rs)
  }

  def licenseKeyFormatting(s: String, k: Int): String = {
    val str = s.replaceAll("-", "").toUpperCase.reverse

    var stringBuilder = new StringBuilder()

    for (i <- Range(0, str.length, k)) {
      val right = if (i + k > str.length) str.length else i + k
      println(s"i = $i ; right = $right")
      stringBuilder.append(str.substring(i, right)).append("-")
    }

    println(stringBuilder)
    if (stringBuilder.last == '-') {
      stringBuilder = stringBuilder.dropRight(1)
    }
    println(stringBuilder)

    stringBuilder.reverse.toString()
  }
}

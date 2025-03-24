package com.kylexu.leetcode.str

import scala.util.boundary
import scala.util.boundary.break

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 */
object Solution925 {
  def main(args: Array[String]): Unit = {
    val name = "laidez"
    val typed = "laideccc"
    val rs = Solution925.isLongPressedName(name, typed)
    println(rs)
  }

  def isLongPressedName(name: String, typed: String): Boolean = {
    if (typed.length < name.length) {
      return false
    }

    val nameCount = countChar(name).split("\\|")
    val stypedCount = countChar(typed).split("\\|")

    if (nameCount.length != stypedCount.length) {
      return false
    }

    println(nameCount.mkString("Array(", ", ", ")"))
    println(stypedCount.mkString("Array(", ", ", ")"))

    val rs = boundary:
      for (i <- Range(0, nameCount.length)) {
//        println(s" ${nameCount(i).charAt(0)} ||| ${stypedCount(i).charAt(0)}")
        if (nameCount(i).charAt(0) != stypedCount(i).charAt(0)) {
          break(false)
        }
        if (nameCount(i).substring(1).toInt > stypedCount(i).substring(1).toInt) {
          break(false)
        }
      }
      true

    rs
  }

  def countChar(str: String): String = {
    val rs = new StringBuilder()

    var preChar = str.charAt(0)
    var count = 1

    if (str.length == 1) {
      return s"$preChar$count"
    }

    for (i <- 1 until str.length) {
      if (preChar == str.charAt(i)) {
        count += 1
      } else {
        rs.append(preChar).append(count).append("|")
        preChar = str.charAt(i)
        count = 1
      }

      if (i == str.length - 1) {
        rs.append(preChar).append(count)
      }
    }

    rs.toString()
  }
}

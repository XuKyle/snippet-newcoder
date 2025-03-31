package com.kylexu.leetcode.array

object Solution804 {
  def main(args: Array[String]): Unit = {
    val words = Array("gin", "zen", "gig", "msg")
    val rs = Solution804.uniqueMorseRepresentations(words)
    println(rs)
  }

  def uniqueMorseRepresentations(words: Array[String]): Int = {
    val alphabet = Array(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")

    words.map {
        word => word.flatMap(ch => alphabet(ch - 'a')).mkString
      }
      .distinct
      .length
  }
}


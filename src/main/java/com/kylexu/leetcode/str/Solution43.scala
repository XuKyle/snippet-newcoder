package com.kylexu.leetcode.str

/*8
示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
 */
object Solution43 {
  def multiply(num1: String, num2: String): String = {
    val m = num1.length
    val n = num2.length

    val maxIndex = m + n;

    var matrix = Array.ofDim[Int](maxIndex, maxIndex)
    for (i <- 0 until n) {
      for (j <- 0 until m) {
        //        println(s" i = $i; num1(i)= ${num1.substring(m - j - 1, m - j)}; j = $j ; num(j)= ${num2.substring(n - i - 1, n - i)}")
        matrix(i)(maxIndex - i - j - 1) = num1.substring(m - j - 1, m - j).toInt * num2.substring(n - i - 1, n - i).toInt
      }
    }

    //    for (elem <- matrix) {
    //      println(elem.mkString("Array(", ", ", ")"))
    //    }

    for (i <- 1 until maxIndex) {
      for (j <- 0 until maxIndex) {
        matrix(0)(j) = matrix(0)(j) + matrix(i)(j)
      }
    }
    //
    //        println("***" * 30)
    //        for (elem <- matrix) {
    //          println(elem.mkString("Array(", ", ", ")"))
    //        }

    val rs = new StringBuilder()
    var left = 0

    for (index <- matrix(0).indices.reverse) {
      val current = matrix(0)(index) + left
      rs.append(current % 10)
      if (current > 9) {
        left = current / 10
      } else {
        left = 0
      }
    }

    var rs1 = rs.reverse.toString()
    while (rs1.length != 1 && rs1.charAt(0) == '0') {
      rs1 = rs1.substring(1)
    }
    rs1
  }

  def main(args: Array[String]): Unit = {
    val num1 = "999"
    val num2 = "0"
    val rs = Solution43.multiply(num1 = num1, num2 = num2)
    println(rs)
  }
}

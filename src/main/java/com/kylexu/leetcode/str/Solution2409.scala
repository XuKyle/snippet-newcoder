package com.kylexu.leetcode.str

object Solution2409 {

  def countDaysTogether(arriveAlice: String, leaveAlice: String, arriveBob: String, leaveBob: String): Int = {
    val days = Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    var sum = 0
    days.indices.foreach(x => sum += days(x))
    //    println(sum)

    val mark = new Array[Int](sum)

    val arriveAliceInt = getDayInt(arriveAlice, days)
    val leaveAliceInt = getDayInt(leaveAlice, days)
    //    println(s"arriveAliceInt = $arriveAliceInt ; leaveAliceInt=  $leaveAliceInt")

    if (arriveAliceInt <= leaveAliceInt) {
      for (i <- arriveAliceInt to leaveAliceInt) {
        mark(i) += 1
      }
    } else {
      for (i <- 0 to leaveAliceInt) {
        mark(i) += 1
      }
      for (i <- arriveAliceInt until sum) {
        mark(i) += 1
      }
    }

    val arriveBobInt = getDayInt(arriveBob, days)
    val leaveBobInt = getDayInt(leaveBob, days)

    //    println(s"arriveBobInt = $arriveBobInt ; leaveBobInt=  $leaveBobInt")

    if (arriveBobInt <= leaveBobInt) {
      for (i <- arriveBobInt to leaveBobInt) {
        mark(i) += 1
      }
    } else {
      for (i <- 0 to leaveBobInt) {
        mark(i) += 1
      }
      for (i <- arriveBobInt until sum) {
        mark(i) += 1
      }
    }

    mark.count(i => i == 2)
  }

  def getDayInt(date: String, days: Array[Int]): Int = {
    val dateSplitter = date.split("-")
    val month = dateSplitter(0).toInt
    val day = dateSplitter(1).toInt

    var sum = 0
    for (i <- 0 until month - 1) {
      sum += days(i)
    }

    sum + day - 1
  }

  def main(args: Array[String]): Unit = {
    //    val arriveAlice = "08-15"
    //    val leaveAlice = "08-18"
    //    val arriveBob = "08-16"
    //    val leaveBob = "08-19"

    //    val arriveAlice = "10-01"
    //    val leaveAlice = "10-31"
    //    val arriveBob = "11-01"
    //    val leaveBob = "12-31"

    val arriveAlice = "12-31"
    val leaveAlice = "12-31"
    val arriveBob = "11-26"
    val leaveBob = "12-14"

    val rs = Solution2409.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob)
    println(rs)
  }

  //  输入
  //  ：arriveAlice = "08-15"
  //  , leaveAlice = "08-18"
  //  , arriveBob = "08-16"
  //  , leaveBob = "08-19"
  //  输出
  //  ：3
  //  解释
  //  ：Alice 从 8 月 15 号到 8 月 18 号在罗马
  //  。Bob 从 8 月 16 号到 8 月 19 号在罗马
  //  ，他们同时在罗马的日期为
  //  8 月 16
  //  、17 和 18 号
  //  。所以答案为
  //  3
  //  示例
  //  2
  //  输入
  //  ：arriveAlice = "10-01"
  //  , leaveAlice = "10-31"
  //  , arriveBob = "11-01"
  //  , leaveBob = "12-31"
  //  输出
  //  ：0
  //  解释
  //  ：Alice 和 Bob 没有同时在罗马的日子
  //  ，所以我们返回
  //  0
  //  。
}


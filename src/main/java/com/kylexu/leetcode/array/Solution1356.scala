package com.kylexu.leetcode.array

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 *
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 *
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 */
object Solution1356 {
  def main(args: Array[String]): Unit = {
    val arr = Array(2, 3, 5, 7, 11, 13, 17, 19)
    val rs = Solution1356.sortByBits(arr)
    println(rs.mkString("Array(", ", ", ")"))
  }

  def sortByBits(arr: Array[Int]): Array[Int] = {
    //    arr.map(it => (it, Integer.toBinaryString(it).count(p => p == '1')))
    //      .sortWith(
    //        (a, b) => if (b._2 == a._2) {
    //          a._1 < b._1
    //        } else if (a._2 > b._2) {
    //          false
    //        } else {
    //          true
    //        }
    //      )
    //      .map(_._1)

//    arr.map(num => Integer.bitCount(num))
//      .foreach(println)

    arr.sortBy(num => (Integer.bitCount(num), num))
  }
}

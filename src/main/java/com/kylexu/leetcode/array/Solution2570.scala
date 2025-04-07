package com.kylexu.leetcode.array

import scala.collection.mutable

/**
 * 示例 1：
 *
 * 输入：nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
 * 输出：[[1,6],[2,3],[3,2],[4,6]]
 * 解释：结果数组中包含以下元素：
 * - id = 1 ，对应的值等于 2 + 4 = 6 。
 * - id = 2 ，对应的值等于 3 。
 * - id = 3 ，对应的值等于 2 。
 * - id = 4 ，对应的值等于5 + 1 = 6 。
 * 示例 2：
 *
 * 输入：nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
 * 输出：[[1,3],[2,4],[3,6],[4,3],[5,5]]
 * 解释：不存在共同 id ，在结果数组中只需要包含每个 id 和其对应的值。
 */
object Solution2570 {
  def main(args: Array[String]): Unit = {
    val nums1 = Array(
      Array(2, 4),
      Array(3, 6),
      Array(5, 5),
    )
    val nums2 = Array(
      Array(1, 4),
      Array(3, 2),
      Array(4, 1),
    )
    val rs = Solution2570.mergeArrays(nums1 = nums1, nums2 = nums2)
    for (elem <- rs) {
      println(elem.mkString("Array(", ", ", ")"))
    }
  }

  def mergeArrays(nums1: Array[Array[Int]], nums2: Array[Array[Int]]): Array[Array[Int]] = {
    //    val sortedMap = mutable.SortedMap[Int, Int]()
    //
    //    for (elem <- nums1) {
    //      sortedMap += (elem(0) -> elem(1))
    //    }
    //
    //    for (elem <- nums2) {
    //      if (sortedMap.contains(elem(0))) {
    //        sortedMap(elem(0)) += elem(1)
    //      } else {
    //        sortedMap += (elem(0) -> elem(1))
    //      }
    //    }
    //
    //    sortedMap.map((k, v) => Array(k, v)).toArray

    val grouped = (nums1 ++ nums2).groupBy(_(0))
    grouped.map {
        case (i, array) => Array(i, array.map(_(1)).sum)
      }
      .toArray
      .sortBy(_(0))
  }
}

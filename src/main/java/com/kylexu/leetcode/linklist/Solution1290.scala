package com.kylexu.leetcode.linklist

import com.kylexu.bean.ListNode

/**
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 *
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 *
 * 输入：head = [0,0]
 * 输出：0
 */
object Solution1290 {
  def main(args: Array[String]): Unit = {
    val head = ListNode.buildListNode(Array(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0))
    val rs = Solution1290.getDecimalValue(head)
    println(rs)
  }

  def getDecimalValue(head: ListNode): Int = {
    var current = head
    var rs = 0

    while (current != null) {
      rs = rs * 2 + current.`val`
      current = current.next
    }

    rs
  }
}

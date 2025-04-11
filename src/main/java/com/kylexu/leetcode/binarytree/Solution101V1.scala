package com.kylexu.leetcode.binarytree

import com.kylexu.bean.{TreeNode, TreeNodeTools}

/**
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
object Solution101V1 {
  def main(args: Array[String]): Unit = {
    import scala.jdk.CollectionConverters._

    val scalaList: List[Int] = List(1, 2, 2, 3, 4, 4, 3)
    val javaList: java.util.List[Integer] = scalaList.map(i => i.asInstanceOf[Integer]).asJava

    val root = TreeNodeTools.buildTree(javaList)
    println(Solution101V1.isSymmetric(root))
  }

  def isSymmetric(root: TreeNode): Boolean = {
    check(root.left, root.right)
  }

  def check(left: TreeNode, right: TreeNode): Boolean = {
    if (left == null && right == null) {
      return true
    }

    if (left == null || right == null) {
      return false
    }

    if (left.`val` == right.`val`) {
      return check(left.right, right.left) && check(left.left, right.right)
    }

    false
  }
}

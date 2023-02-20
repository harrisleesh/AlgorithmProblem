package leetcode

import getHeight
import kotlin.math.max

fun main() {
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(9)
    val node6 = TreeNode(6)
    val node7 = TreeNode(7)
    node4.left = node2
    node4.right = node7
    node2.left = node1
    node2.right = node3
//    node7.left = node6
//    node7.right = node5
    println(diameterOfBinaryTree(node4))
}
fun diameterOfBinaryTree(root: TreeNode?): Int {
    if(root == null) return 0

    return max(getHeight(root.left) + getHeight(root.right), max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)))
}

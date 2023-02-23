package leetcode

fun main() {
    println("Hello kth smallest")
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)
//    val node7 = TreeNode(7)
    node3.left = node1
    node3.right = node4
//    node1.left = node2
    node1.right = node2
//    node2.left = node1
//    node7.right = node5
    println(kthSmallest(node3, 4))

}

var count = 0
fun kthSmallest(root: TreeNode?, k: Int): Int {
    if (root == null) return -1
    val leftResult = kthSmallest(root.left, k)
    if (leftResult != -1) return leftResult
    count++
    if (count == k) {
        return root.`val`
    }
    val rightResult = kthSmallest(root.right, k)
    if (rightResult != -1) return rightResult
    return -1
}

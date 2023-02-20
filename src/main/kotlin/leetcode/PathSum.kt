package leetcode

fun main() {
    println("Hello path sum")
    val node1 = TreeNode(1000000000)
    val node2 = TreeNode(1000000000)
//    val node3 = TreeNode(-3)
    val node4 = TreeNode(294967296)
//    val node5 = TreeNode(3)
    val node6 = TreeNode(1000000000)
//    val node7 = TreeNode(3)
    val node8 = TreeNode(1000000000)
//    val node9 = TreeNode(1)
    val node10 = TreeNode(1000000000)
    node1.left = node2
//    node1.right = node3
    node2.left = node4
//    node2.right = node5
//    node3.right = node6
//    node4.left = node7
    node4.right = node8
//    node5.right = node9
    val a = 1000000000
    println(50 -a -a -a)
    println(pathSum(node1, -1))
    println(pathSumFromRoot(node1, -1))
}

fun pathSum(root: TreeNode?, targetSum: Int): Int {
    if(root == null) return 0
    return pathSumFromRoot(root, targetSum.toLong()) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
}

fun pathSumFromRoot(root: TreeNode?, targetSum: Long): Int {
    if (root == null) return 0
    if(targetSum > 1000000000 || targetSum < -1000000000) return 0
    val match = if (targetSum == root.`val`.toLong()) 1 else 0
    return pathSumFromRoot(root.left, targetSum - root.`val`) + pathSumFromRoot(root.right, targetSum - root.`val`) + match
}

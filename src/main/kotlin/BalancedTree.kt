import kotlin.math.max

fun main() {
    println("Hello is balanced tree")
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(9)
    val node6 = TreeNode(6)
    val node7 = TreeNode(7)
    node4.left = node2
    node4.right = node7
//    node2.left = node1
//    node2.right = node3
    node7.left = node6
    node7.right = node5
    println(isBalanced(node4))
}

fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true
    val balanced = (getHeight(root.left) - getHeight(root.right)) in -1.. 1
    return balanced && isBalanced(root.left) && isBalanced(root.right)
}

fun getHeight(node: TreeNode?): Int {
    val curr = node ?: return 0
    return 1 + max(getHeight(curr.left), getHeight(curr.right))
}

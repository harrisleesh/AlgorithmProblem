package leetcode

public class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
fun TreeNode.printAll(){
    var curr = this
    if(curr!=null){
        print(this.`val`)
    }
    this.left?.printAll()
    this.right?.printAll()
}
fun main() {
    println("hello tree")
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
    node7.left = node6
    node7.right = node5
    invertTree(node4)
    node4.printAll()
}

fun invertTree(root: TreeNode?): TreeNode? {
    val curr = root ?: return root
    val temp = curr.left
    curr.left = curr.right
    curr.right = temp
    invertTree(curr.left)
    invertTree(curr.right)

    return root
}

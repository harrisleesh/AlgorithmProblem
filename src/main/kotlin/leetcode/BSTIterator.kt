package leetcode

class BSTIterator(root: TreeNode?) {
    val iterator = mutableListOf<Int>()
    var count = 0

    init {
        addInOrder(root)
    }

    fun next(): Int {
        return iterator[count++]
    }

    fun hasNext(): Boolean {
        return count < iterator.size
    }

    fun addInOrder(root: TreeNode?) {
        if (root == null) return
        addInOrder(root.left)
        iterator.add(root.`val`)
        addInOrder(root.right)
    }
}

fun main() {
    println("hello BSTIterator")

}

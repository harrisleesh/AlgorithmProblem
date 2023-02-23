package leetcode

fun main() {
    println("hello bst")
    val sortedArrayToBST = sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
    sortedArrayToBST?.printAll()
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if(nums.isEmpty()) return null
    val med = nums.size / 2
    val node = TreeNode(nums[med])
    if(nums.size == 1) return node
    node.left = sortedArrayToBST(nums.copyOfRange(0, med))
    node.right = sortedArrayToBST(nums.copyOfRange(med+1, nums.size))
    return node
}

package leetcode

fun main() {
    println("Hello SearchedRotated SortedArray")
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 5))
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 2))
    println(search(intArrayOf(1,3), 1))

}


fun search(nums: IntArray, target: Int): Int {
    var startIdx = 0
    var endIdx = nums.size
    var medIdx = (startIdx + endIdx) / 2
    val visited = mutableSetOf(medIdx)
    while (true) {
        if (target == nums[medIdx]) {
            return medIdx
        } else if (nums[startIdx] < nums[medIdx]) {
            if (nums[startIdx] <= target && target < nums[medIdx]) {
                endIdx = medIdx
            } else {
                startIdx = medIdx
            }
        } else {
            if (nums[medIdx] < target && target <= nums[endIdx - 1]) {
                startIdx = medIdx
            } else {
                endIdx = medIdx
            }
        }
        medIdx = (startIdx + endIdx) / 2
        if (visited.contains(medIdx)) return -1
        visited.add(medIdx)
    }
    return -1
}

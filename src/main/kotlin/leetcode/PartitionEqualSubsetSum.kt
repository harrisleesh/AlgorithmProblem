package leetcode

fun main() {
    println("hello partition equal subset sum")
    println(canPartition(intArrayOf(1, 5, 11, 5)))
    println(canPartition(intArrayOf(1, 2, 3, 5)))
}

/**
 * 1. 먼저 sum/2 를 구한다.
 * 2. sum 이 홀수면 return false
 * 2. 각 부분집합의 합이 sum/2가 되는지 확인한다.
 */
fun canPartition(nums: IntArray): Boolean {

    val sumByTwo = if (nums.sum() % 2 == 0) nums.sum() / 2 else return false
    val sum = mutableSetOf<Int>()
    val numsList = nums.toMutableList()
    recur(numsList, sum)
    return sum.contains(sumByTwo)
}

fun recur(numsList: MutableList<Int>, sum: MutableSet<Int>) {
    val first = (if (numsList.isEmpty()) null else numsList.removeAt(0))
        ?: return
    sum.addAll(sum.map {
        it + first
    })
    sum.add(first)
    recur(numsList, sum)
}

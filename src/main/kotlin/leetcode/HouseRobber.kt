package leetcode

import kotlin.math.max

fun main() {
    println("hello house robber")

    println(rob(intArrayOf(1,2,3,1)))
    println(rob(intArrayOf(2,7,9,3,1)))
    println(rob(intArrayOf(2,1,1,2)))
}

fun rob(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    else if(nums.size == 2) return max(nums[0], nums[1])
    val memory = mutableListOf(nums[0], nums[1], nums[0] + nums[2])
    (3 until nums.size).forEach {
        val newMax = max(memory[it-3], memory[it-2]) + nums[it]
        memory.add(newMax)
    }


    return max(memory[memory.size-1], memory[memory.size-2])
}

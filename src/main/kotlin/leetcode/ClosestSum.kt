import kotlin.math.abs

fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    var minDiff = Int.MAX_VALUE
    var candidate = Int.MAX_VALUE
    nums.indices.forEach { firstIdx ->
        var secondIdx = firstIdx + 1
        var thirdIdx = nums.size - 1
        while(secondIdx < thirdIdx){
            val sum = nums[firstIdx] + nums[secondIdx] + nums[thirdIdx]
            val diff = abs(sum - target)
            if(minDiff > diff) {
                minDiff = diff
                candidate = sum
            }
            if(target < sum){
                thirdIdx--
            } else if(target > sum){
                secondIdx++
            } else {
                return target
            }
        }
    }
    return candidate
}


fun main() {
    println("hello three sum")
    println(
        threeSumClosest(
            intArrayOf(1, 2, 3),
            5
        ),
    )
}

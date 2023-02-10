fun threeSum(nums: IntArray): List<List<Int>> {
    val countMap = mutableMapOf<Int, Int>()
    nums.forEach { countMap[it] = countMap.getOrDefault(it, 0) + 1 }
    val candidates = mutableSetOf<List<Int>>()
    nums.sort()
    (nums.indices).forEach { first ->
        (first + 1 until nums.size).forEach { second ->
            val third = -(nums[first] + nums[second])
            val thirdCount = countMap[third]
            if ((thirdCount == 1 && nums[first] != third && nums[second] != third) || thirdCount!! >= 3) {
                candidates.add(listOf<Int>(nums[first], nums[second], third).sorted())
            } else if (thirdCount == 2) {
                if (third == nums[first] || third == nums[second]) {
                    if (nums[first] != nums[second]) {
                        candidates.add(listOf<Int>(nums[first], nums[second], third).sorted())
                    }
                } else {
                    candidates.add(listOf<Int>(nums[first], nums[second], third).sorted())
                }
            }
        }
    }
    return candidates.toList()
}

fun optThreeSum(nums: IntArray): List<List<Int>> {
    val candidates = mutableSetOf<List<Int>>()
    nums.sort()
    (nums.indices).forEach { first ->
        var second = first + 1
        var third = nums.size - 1
        while (second < third) {
            if (nums[first] + nums[second] + nums[third] == 0) {
                candidates.add(listOf(nums[first], nums[second], nums[third]))
                second++
                third--
            }
            else if (nums[first] + nums[second] + nums[third] > 0) {
                third--
            }
            else if (nums[first] + nums[second] + nums[third] < 0) {
                second++
            }

        }
    }
    return candidates.toList()
}

fun main() {
    println("hello sum nums")
    println(optThreeSum(intArrayOf(0, 0, 0, 0)))
}

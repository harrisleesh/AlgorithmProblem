import kotlin.math.max
import kotlin.math.min

fun main() {
    println("Hello main")
    println(maxArea(intArrayOf(1)))
}

fun maxArea(height: IntArray): Int {
    val size = height.size
    var maxArea = 0
    for (i in 0 until size) {
        val leftHeight = height[i]
        var maxRightHeight = 0
        for (j in height.size - 1 downTo i + 1) {
            val rightHeight = height[j]
            if(rightHeight > maxRightHeight) maxRightHeight = rightHeight else continue
            if (rightHeight >= leftHeight) {
                val area = leftHeight * (j - i)
                if (area > maxArea) {
                    maxArea = area
                }
                break
            }
            val area = rightHeight * (j - i)
            if (area > maxArea) {
                maxArea = area
            }
        }
    }
    return maxArea
}

fun maxAreaOpt(height: IntArray): Int {
    var j = height.size - 1
    var i = 0
    var maxArea = 0

    while (i < j){
        val actualHeight = min(height[i], height[j])
        maxArea = max(maxArea, actualHeight * (j - i))
        if(height[i] == actualHeight) i ++ else j--
    }
    return maxArea
}

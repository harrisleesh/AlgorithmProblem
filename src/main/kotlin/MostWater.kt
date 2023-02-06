import kotlin.math.max

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

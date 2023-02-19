package leetcode

fun main() {
    println("Hello Spiral")
    println(spiralOrder(arrayOf(intArrayOf(1,2,3),intArrayOf(4,5,6),intArrayOf(7,8,9))))
}


fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val result = mutableListOf<Int>()
    val height = matrix.size
    val width = matrix[0].size
    val navMatrix = Array(height) { BooleanArray(width) }
    var direction = Direction.RIGHT
    var position = Pair(0, 0)
    while (true) {
        if(navMatrix[position.first][position.second]) break
        navMatrix[position.first][position.second] = true
        result.add(matrix[position.first][position.second])
        val nextPosition = direction.nextPosition(position)
        if(!(nextPosition.first in 0 until  height && nextPosition.second in 0 until width) || navMatrix[nextPosition.first][nextPosition.second]){
            direction = direction.nextDirection()
        }
        position = direction.nextPosition(position)
        if(!(position.first in 0 until  height && position.second in 0 until width)) break
    }
    return result
}

enum class Direction {
    TOP,
    BOTTOM,
    LEFT,
    RIGHT;

    fun nextDirection() = when (this) {
        TOP -> RIGHT
        RIGHT -> BOTTOM
        BOTTOM -> LEFT
        LEFT -> TOP
    }

    fun nextPosition(pos: Pair<Int, Int>) = when (this) {
        TOP -> Pair(pos.first - 1, pos.second)
        RIGHT -> Pair(pos.first, pos.second + 1)
        BOTTOM -> Pair(pos.first + 1, pos.second)
        LEFT -> Pair(pos.first, pos.second - 1)
    }
}

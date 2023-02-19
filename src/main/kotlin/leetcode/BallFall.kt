fun main() {
    println("hello ballfall")
}

fun findBall(grid: Array<IntArray>): IntArray {
    val width = grid[0].size
    val result = IntArray(width) { 0 }
    (0 until width).forEach {
        var pos = it
        grid.forEach { array ->
            pos = findNextBallWithPos(array, pos)
        }
        result[it] = pos
    }
    return result
}

fun findNextBall(row: IntArray, balls: Array<Boolean>): Array<Boolean> {
    val nextBalls = Array(row.size) { false }
    (0 until row.size - 1).forEach {
        if (row[it] == row[it + 1]) {
            if (row[it] == 1 && balls[it]) nextBalls[it + 1] = true
            else if (row[it] == -1 && balls[it + 1]) nextBalls[it] = true
        }
    }
    return nextBalls
}

fun findNextBallWithPos(row: IntArray, pos: Int): Int {
    if(pos == -1) return -1
    if (row[pos] == 1) {
        if (pos + 1 >= row.size) return -1
        if (row[pos] == row[pos + 1]) {
            return pos + 1
        }
    } else if (row[pos] == -1) {
        if (pos - 1 < 0) return -1
        if (row[pos] == row[pos - 1]) {
            return pos - 1
        }
    }
    return -1
}

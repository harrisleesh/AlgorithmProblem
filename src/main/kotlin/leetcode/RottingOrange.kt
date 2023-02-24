package leetcode

fun main() {
    println("Hello orange rotting")
    println(orangesRotting(arrayOf(intArrayOf(2,1,1), intArrayOf(1,1,0), intArrayOf(0,1,1))))
}


fun orangesRotting(grid: Array<IntArray>): Int {
    var candidate = mutableSetOf<Pair<Int, Int>>()
    grid.forEachIndexed { rowIdx, col ->
        col.forEachIndexed { colIdx, orange ->
            if (orange == 2) {
                candidate.add(Pair(rowIdx, colIdx))
            }
        }
    }
    var count = 0
    while (candidate.isNotEmpty()) {

        val newPairs = candidate.flatMap {
            setOf(
                Pair(it.first - 1, it.second),
                Pair(it.first + 1, it.second),
                Pair(it.first, it.second - 1),
                Pair(it.first, it.second + 1)
            )
        }.filter { it.first in grid.indices && it.second in grid[0].indices }
            .filter { grid[it.first][it.second] == 1 }
            .onEach { grid[it.first][it.second] = 2 }
        candidate = newPairs.toMutableSet()
        if(candidate.isNotEmpty()){
            count++
        }
    }
    grid.forEach {
        it.forEach { orange ->
            if (orange == 1) {
                return -1
            }
        }
    }
    return count
}

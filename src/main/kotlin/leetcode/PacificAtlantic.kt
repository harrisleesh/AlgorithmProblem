package leetcode

import kotlin.math.min

fun main() {
    println("hello pacific and atlantic")
    println(
        pacificAtlantic(
            arrayOf(
                intArrayOf(1, 2, 2, 3, 5),
                intArrayOf(3, 2, 3, 4, 4),
                intArrayOf(2, 4, 5, 3, 1),
                intArrayOf(6, 7, 1, 4, 5),
                intArrayOf(5, 1, 1, 2, 4)
            )
        )
    )
//    println(
//        pacificAtlantic(
//            arrayOf(
////                intArrayOf(0),
////                intArrayOf(3, 2, 3, 4, 4),
////                intArrayOf(2, 4, 5, 3, 1),
////                intArrayOf(6, 7, 1, 4, 5),
////                intArrayOf(5, 1, 1, 2, 4)
//            )
//        )
//    )
}

fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    val rowSize = heights.size
    val colSize = heights[0].size
    val pacific = Array(rowSize) { Array(colSize) { false } }
    val atlantic = Array(rowSize) { Array(colSize) { false } }
    (0 until rowSize).forEach { row ->
        dfs(row, rowSize, 0, colSize, pacific, -1, heights)
        dfs(rowSize - row - 1, rowSize, colSize - 1, colSize, atlantic, -1, heights)
    }
    (0 until colSize).forEach { col ->
        dfs(0, rowSize, col, colSize, pacific, -1, heights)
        dfs(rowSize - 1, rowSize, colSize - col - 1, colSize, atlantic, -1, heights)
    }
    val result = mutableListOf<List<Int>>()
    (0 until rowSize).forEach { row ->
        (0 until colSize).forEach { col ->
            if (pacific[row][col] && atlantic[row][col]) result.add(listOf(row, col))
        }
    }
    return result
}

fun dfs(
    row: Int,
    rowSize: Int,
    col: Int,
    colSize: Int,
    continent: Array<Array<Boolean>>,
    prevHeight: Int,
    heights: Array<IntArray>,
) {
    if (row < 0 || row >= rowSize || col < 0 || col >= colSize || continent[row][col] || prevHeight > heights[row][col]) return

    continent[row][col] = true

    dfs(row - 1, rowSize, col, colSize, continent, heights[row][col], heights)
    dfs(row + 1, rowSize, col, colSize, continent, heights[row][col], heights)
    dfs(row, rowSize, col - 1, colSize, continent, heights[row][col], heights)
    dfs(row, rowSize, col + 1, colSize, continent, heights[row][col], heights)

}

fun pacificAtlantic2(heights: Array<IntArray>): List<List<Int>> {
    val rowSize = heights.size
    val colSize = heights[0].size
    val pacificMap = ((0 until rowSize).map {
        Pair(it, 0) to heights[it][0]
    } + (0 until colSize).map { Pair(0, it) to heights[0][it] })
        .toMap()
        .toMutableMap()

    (1 until min(rowSize, colSize)).forEach { depth ->
        (depth until rowSize).asSequence().filter {
            (pacificMap[Pair(it, depth - 1)] != null && pacificMap[Pair(it, depth - 1)]!! <= heights[it][depth]) ||
                    (pacificMap[Pair(it - 1, depth)] != null && pacificMap[Pair(it - 1, depth)]!! <= heights[it][depth])
        }.forEach { pacificMap[Pair(it, depth)] = heights[it][depth] }
        (depth until colSize).asSequence().filter {
            (pacificMap[Pair(depth - 1, it)] != null && pacificMap[Pair(depth - 1, it)]!! <= heights[depth][it]) ||
                    (pacificMap[Pair(depth, it - 1)] != null && pacificMap[Pair(depth, it - 1)]!! <= heights[depth][it])
        }.forEach {
            pacificMap[Pair(depth, it)] = heights[depth][it]
        }
    }
    println(pacificMap)

    val atlanticMap = ((0 until rowSize).map {
        Pair(it, colSize - 1) to heights[it][colSize - 1]
    } + (0 until colSize).map { Pair(rowSize - 1, it) to heights[rowSize - 1][it] })
        .toMap()
        .toMutableMap()
    (1 until min(rowSize, colSize)).forEach { depth ->
        (depth until rowSize).asSequence().filter {
            (pacificMap[Pair(it, depth - 1)] != null && pacificMap[Pair(it, depth - 1)]!! <= heights[it][depth]) ||
                    (pacificMap[Pair(it - 1, depth)] != null && pacificMap[Pair(it - 1, depth)]!! <= heights[it][depth])
        }.forEach { pacificMap[Pair(it, depth)] = heights[it][depth] }
        (depth until colSize).asSequence().filter {
            (pacificMap[Pair(depth - 1, it)] != null && pacificMap[Pair(depth - 1, it)]!! <= heights[depth][it]) ||
                    (pacificMap[Pair(depth, it - 1)] != null && pacificMap[Pair(depth, it - 1)]!! <= heights[depth][it])
        }.forEach {
            pacificMap[Pair(depth, it)] = heights[depth][it]
        }
    }

    return listOf()
}

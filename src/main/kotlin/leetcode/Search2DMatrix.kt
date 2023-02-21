package leetcode

fun main() {
    println("Hello 2D matrix")
    println(searchMatrix(arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60)), 0))
}


fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val rowCount = matrix.size
    val columnCount = matrix[0].size
    var start = 0
    var end = rowCount
    var medRow = (start + rowCount) / 2
    var medColumn = (0 + columnCount) / 2
    val visitedRow = mutableSetOf(medRow)
    val visitedColumn = mutableSetOf(medColumn)
    while (true) {
        if (target < matrix[medRow][0]) {
            end = medRow
        } else if (target >= matrix[medRow][0] && target <= matrix[medRow][columnCount-1]) {
            var startColumn = 0
            var endColumn = columnCount
            while (true) {
                if (matrix[medRow][medColumn] == target) return true
                else if (target < matrix[medRow][medColumn]) {
                    endColumn = medColumn
                } else {
                    startColumn = medColumn
                }
                medColumn = (startColumn + endColumn) / 2
                if (visitedColumn.contains(medColumn)) return false
                visitedColumn.add(medColumn)
            }
        } else {
            start = medRow
        }

        medRow = (start + end) / 2
        if (visitedRow.contains(medRow)) return false
        else visitedRow.add(medRow)
    }
    return true
}

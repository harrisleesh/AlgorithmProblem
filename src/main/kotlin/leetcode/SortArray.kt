fun main() {
    println("Hello sort world")

    val array = arrayOf(5, 2, 6, 4, 1, 3)
    val res = quickSort(array, 0, array.size - 1)
//    mergeSort(array, 0, array.size - 1)
    println()
}

fun quickSort(array: Array<Int>, start: Int, end: Int) {
    if (start >= end) return
    val pivot = array[end]
    var leftIdx = start
    (leftIdx until end).forEach {
        if (array[it] < pivot) {
            swap(array, leftIdx++, it)
        }
    }
    swap(array, leftIdx, end)
    quickSort(array, start, leftIdx - 1)
    quickSort(array, leftIdx + 1, end)
}

fun swap(array: Array<Int>, fromIdx: Int, toIdx: Int) {
    println("$fromIdx , $toIdx")
    val temp = array[fromIdx]
    array[fromIdx] = array[toIdx]
    array[toIdx] = temp
}

fun mergeSort(array: Array<Int>, start: Int, end: Int) {
    if (start >= end) return
    val mid = (start + end) / 2
    mergeSort(array, start, mid)
    mergeSort(array, mid + 1, end)
    merge(array, start, mid, end)
}

fun merge(array: Array<Int>, start: Int, mid: Int, end: Int) {
    var leftIdx = 0
    var rightIdx = 0
    var arrayIdx = start
    val left = array.copyOfRange(start, mid+1)
    val right = array.copyOfRange(mid+1, end+1)
    while (leftIdx < left.size && rightIdx < right.size) {
        if (left[leftIdx] <= right[rightIdx]) {
            array[arrayIdx++] = left[leftIdx++]
        } else {
            array[arrayIdx++] = right[rightIdx++]
        }
    }
    while (leftIdx < left.size) {
        array[arrayIdx++] = left[leftIdx++]
    }
    while (rightIdx < right.size) {
        array[arrayIdx++] = right[rightIdx++]
    }
}

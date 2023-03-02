package leetcode


fun main() {
    println("hello bus route")

    println(numBusesToDestination("[1,7],[3,5]".toArrayOfIntArray(), 5, 5))
    println(numBusesToDestination("[1,2,7],[3,6,7]".toArrayOfIntArray(), 1, 6))
    println(numBusesToDestination("[7,12],[4,5,15],[6],[15,19],[9,12,13]".toArrayOfIntArray(), 15, 12))
}

private fun String.toArrayOfIntArray(): Array<IntArray> {
    return this.split("],[").map { str ->
        str.split("]", ",", "[")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }.toTypedArray().toIntArray()
    }.toTypedArray()
}

/**
 * 1. BFS 방식으로 문제를 해결할 수 있을듯
 * 2. 각 노드로부터 탈수있는 버스의 목록을 갖는 맵을 만들자
 * 3. source로 부터 시작한다.
 * 4. source에서 탈수있는 버스의 종착지들에 target이 있는지 확인한다.
 * 5. bus 에 visited를 표시한다.
 * 6. 해당 버스의 종착지들로 부터 환승 가능한 버스들의 목록중에서 visited가 false인 버스들만 추린다.
 * 7. 만약 위의 추려진 버스들이 없다면 return -1
 * 8. 추려진 버스들의 종착지들에 target이 있는지 다시한번 확인한다.
 * 9. bus 에 visited를 표시한다.
 * 10. 위의 과정을 반복한다.
 */


fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
    if(source == target) return 0
    val busStopToBusNum = mutableMapOf<Int, MutableList<Int>>()
    val busTaken = Array(routes.size) { false }
    routes.forEachIndexed { index, ints ->
        ints.forEach { stop ->
            val busNum = busStopToBusNum.getOrDefault(stop, mutableListOf())
            busNum.add(index)
            busStopToBusNum[stop] = busNum
        }
    }
    val deq = ArrayDeque<Pair<Int, Int>>()
    busStopToBusNum[source]?.let { busNums -> deq.addAll(busNums.map { it to 1 }) }
    while (deq.isNotEmpty()) {
        val (busNum, count) = deq.removeFirst()
        if (!busTaken[busNum]) {
            busTaken[busNum] = true
            routes[busNum].forEach { stop ->
                if (stop == target) return count
                busStopToBusNum[stop]?.let { busNums -> deq.addAll(busNums.map { it to count + 1 }) }
            }
        }
    }
    return -1
}

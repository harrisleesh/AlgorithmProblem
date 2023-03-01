package leetcode

fun main() {
    println("Hello Course schedule")
//    println(findOrder(2, arrayOf(intArrayOf(1, 0))).toSet())
//    println(findOrder(4, arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 1), intArrayOf(3, 2))).toSet())
//    println(findOrder(1, arrayOf()).toSet())
    println(findOrder(3, arrayOf(intArrayOf(1,0), intArrayOf(1,2), intArrayOf(0,1))).toSet())
}

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val inboundCount = Array(numCourses) { 0 }
    initInbound(inboundCount, prerequisites)
    val visited = Array(numCourses) { false }
    val queue = ArrayDeque<Int>()
    val order = mutableListOf<Int>()
    inboundCount.forEachIndexed { index, value ->
        if(value == 0) {
            visited[index] = true
            queue.add(index)
            order.add(index)
        }

    }
    while(queue.isNotEmpty()){
        val pre = queue.removeFirst()
        prerequisites.filter { it[1] == pre }
            .forEach {
                if(visited[it[0]]) return intArrayOf()
                inboundCount[it[0]]--
            }
        inboundCount.forEachIndexed { index, value ->
            if(value == 0 && !visited[index]) {
                visited[index] = true
                queue.add(index)
                order.add(index)
            }

        }
    }
    if(order.size < numCourses) return intArrayOf()
    return order.toIntArray()
}

fun initInbound(inboundCount: Array<Int>, prerequisites: Array<IntArray>) {
    prerequisites.forEach {
        inboundCount[it[0]]++
    }
}

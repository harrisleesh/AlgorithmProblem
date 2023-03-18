package programmers

import kotlin.math.max

fun main() {
    println("hello pulse")
    println(solution(intArrayOf(2, 3, -6, 1, 3, -1, 2, 4, 13)))
}


fun solution(sequence: IntArray): Long {
    val oddPulse = sequence.mapIndexed { index, it -> (if (index % 2 == 0) it * -1 else it).toLong() }
    val evenPulse = sequence.mapIndexed { index, it -> (if (index % 2 == 1) it * -1 else it).toLong() }
    val oddDp = Array(sequence.size){0L}
    val evenDp = Array(sequence.size){0L}
    oddDp[0] = oddPulse[0]
    var max = oddDp[0]
    (1 until oddPulse.size).forEach {
        oddDp[it] = if(oddDp[it - 1] >= 0) oddPulse[it] + oddDp[it-1] else oddPulse[it]
        max = max(max, oddDp[it])
    }
    evenDp[0] = evenPulse[0]
    (1 until evenPulse.size).forEach {
        evenDp[it] = if(evenDp[it - 1] >= 0) evenPulse[it] + evenDp[it-1] else evenPulse[it]
        max = max(max, evenDp[it])
    }
    return max
}

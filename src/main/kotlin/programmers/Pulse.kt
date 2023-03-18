package programmers

fun main() {
    println("hello pulse")
    println(solution(intArrayOf(2, 3, -6, 1, 3, -1, 2, 4)))
}


fun solution(sequence: IntArray): Long {
    val oddPulse = sequence.mapIndexed { index, it -> if (index % 2 == 0) it * -1 else it }
    val evenPulse = sequence.mapIndexed { index, it -> if (index % 2 == 1) it * -1 else it }
    val oddDp = Array(sequence.size){0}
    val evenDp = Array(sequence.size){0}
    var answer: Long = 0
    return answer
}

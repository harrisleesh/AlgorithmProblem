package programmers

import kotlin.math.max

fun main() {
    println("Hello insagogwa")
    println(solution(arrayOf(intArrayOf(2, 2), intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(3, 2), intArrayOf(2, 1))))
}

fun solution(scores: Array<IntArray>): Int {
    val wanhoScore = scores[0]
    // 거르기
    val filteredScores = scores.filter { it.sum() > wanhoScore.sum() }
    // 기준점들 찾기
    val maxGroup = filteredScores.groupingBy { it[0] }
        .fold(0) { acc, e -> max(acc, e[1]) }

    if(!maxGroup.keys.filter { it > wanhoScore[0] }
        .all{ (maxGroup[it] ?: -1) <= wanhoScore[1] }) return -1

    val validated = filteredScores.filter { score ->
        maxGroup.keys.filter { it > score[0] }
            .all{ (maxGroup[it] ?: -1) <= score[1] }
    }
    val result = validated.groupingBy { it[0] + it[1] }.eachCount()
    return result.keys.filter { it > wanhoScore.sum() }.mapNotNull { result[it] }.sum() + 1
}

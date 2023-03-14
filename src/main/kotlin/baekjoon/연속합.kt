package baekjoon

import kotlin.math.max

fun main() {
    println("hello 연속합")
    val count = readln().toInt()
    val array = readln().split(" ")
        .map { it.toInt() }

    val dp = Array(count) { 0 }
    var max = array[0]
    dp[0] = array[0]
    (1 until count).forEach {
        dp[it] = if (dp[it - 1] > 0) dp[it - 1] + array[it] else array[it]
        max = max(dp[it], max)
    }
    println(max)
}


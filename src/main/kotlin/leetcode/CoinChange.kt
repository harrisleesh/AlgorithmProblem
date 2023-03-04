package leetcode

fun main() {
    println("Hello Coin Change")
//    println(coinChange(intArrayOf(1, 2, 5), 11))
//    println(coinChange(intArrayOf(2), 3))
//    println(coinChange(intArrayOf(1), 0))
//    println(coinChange(intArrayOf(1, 4, 5), 8))
//    println(coinChange(intArrayOf(2,5,10,1), 27))
//    println(coinChange(intArrayOf(186,419,83,408), 6249))
    println(coinChange(intArrayOf(411,412,413,414,415,416,417,418,419,420,421,422), 9864))
}

/**
 * DP로 문제를 해결한다.
 * 1. 11원을 계산하기 위해서는 (11 - 1), (11 - 2), (11 - 5) 원을 구하기 위한 동전의 최소 개수 + 1 이다.
 * 2. 이렇게 되면 마지막 (1 - 1), (2 - 2), (5 - 5) 까지 재귀적으로 계산이 되게 되고 1, 2, 5원의 계산은 1개의 동전이 필요함을 알 수 있다.
 * 3. 예외적으로 계산이 되지 않는 부분들은 최소 개수를 구할 때 제외할 수 있도록 처리한다.
 * 4. 각 값을 구하는 데에 들어가는 최소 개수를 배열로 기억해둔다. (DP)
 */
fun coinChange(coins: IntArray, amount: Int): Int {
    return 0
}

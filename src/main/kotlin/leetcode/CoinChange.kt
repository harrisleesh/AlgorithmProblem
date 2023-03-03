package leetcode

fun main() {
    println("Hello Coin Change")
    println(coinChange(intArrayOf(1, 2, 5), 11))
    println(coinChange(intArrayOf(2), 3))
    println(coinChange(intArrayOf(1), 0))
}

fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount == 0) return 0
    else if(coins.isEmpty()) return -1

    (coins.size - 1 downTo 0).forEach {
        val count = amount / coins[it]
        (0..count).forEach { mCount ->

            coinChange(coins.copyOfRange(0, it - 1), amount - coins[it] * mCount)
        }
    }
    return 0
}

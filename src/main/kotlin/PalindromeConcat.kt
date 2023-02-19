import kotlin.math.max

fun main() {
    println("hello palindrome concatenate")
    println(longestPalindrome(arrayOf("lc","cl","gg")))
    println(longestPalindrome(arrayOf("ab","ty","yt","lc","cl","ab")))
    println(longestPalindrome(arrayOf("cc","ll","xx")))

}

fun longestPalindrome(words: Array<String>): Int {
    val dictionary = mutableMapOf<String, Int>()
    var totalLen = 0
    words.forEach {
        val pairCount = dictionary[it.reversed()]
        if (pairCount == null || pairCount < 1) {
            val count = dictionary.getOrDefault(it, 0)
            dictionary[it] = count + 1
        } else {
            if (pairCount == 1) {
                dictionary.remove(it.reversed())
            } else {
                dictionary[it.reversed()] = pairCount - 1
            }
            totalLen += it.length * 2
        }
    }
    var maxPalindrome = 0
    dictionary.keys.forEach {
        if(it.isPalindrome()) maxPalindrome = max(maxPalindrome, it.length)
    }
    return totalLen + maxPalindrome
}

fun String.isPalindrome(): Boolean {
    (0 until length / 2).forEach{
        if(this[it] != this[length-it-1]){
            return false
        }
    }
    return true
}

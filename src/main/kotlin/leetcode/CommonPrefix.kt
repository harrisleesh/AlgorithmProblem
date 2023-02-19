import kotlin.math.min

fun main() {
    println("Hello Longest common prefix")
}


fun longestCommonPrefix(strs: Array<String>): String {
    var lastIdx = 0
    var minLen = Int.MAX_VALUE
    strs.forEach { minLen = min(minLen, it.length) }
    while(lastIdx < minLen){
        val sameChar = strs[0][lastIdx]
        strs.forEach { if(it[lastIdx] != sameChar) return it.substring(0, lastIdx) }
        lastIdx++
    }
    return strs[0].substring(0, lastIdx)
}

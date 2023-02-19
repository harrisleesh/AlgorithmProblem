fun main() {
    println("Hello reg exp matching")
}


fun isMatch(s: String, p: String): Boolean {
    val sIdx = 0
    val pIdx = 0
    return isMatch(s, p, sIdx, pIdx)
}

fun isMatch(s: String, p: String, sIdx: Int, pIdx: Int): Boolean {
    if (p.isEmpty()) return s.isEmpty()
    val firstMatch = s.isNotEmpty() && (p[0] == s[0] || p[0] == '.')
    return if (p.length >= 2 && p[1] == '*')
        isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p)
    else
        firstMatch && isMatch(s.substring(1), p.substring(1))
}

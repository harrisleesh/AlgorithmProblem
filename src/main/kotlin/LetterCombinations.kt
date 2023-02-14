fun main() {
    println("Hello Letters")
    println(letterCombinations(""))
}


fun letterCombinations(digits: String): List<String> {
    if (digits.isBlank()) return listOf()

    return letterCombinationsRec(digits)
}
fun letterCombinationsRec(digits: String): List<String> {
    if (digits.isBlank()) return listOf("")

    return getLetters(Character.getNumericValue(digits[0])).flatMap { letter -> letterCombinationsRec(digits.substring(1)).map { "$letter$it" } }
}

fun getLetters(digit: Int): List<String> {
    var first = (digit - 2) * 3
    var last = (digit - 1) * 3
    if (digit == 7) {
        last++
    }
    if (digit == 8) {
        first++
        last++
    }
    if (digit == 9) {
        first++
        last += 2
    }
    val alphabets = "abcdefghijklmnopqrstuvwxyz"
    return alphabets.substring(first, last).map { "$it" }
}

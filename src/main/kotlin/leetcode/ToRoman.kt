fun main() {
    println("Hello Roman")
    println(intToRoman(1994))
}

fun intToRoman(num: Int): String {
    val thousands = num / 1000
    val romanThousands = (0 until thousands).map { "M" }.joinToString(separator = "")

    val hundredsRemainder = num % 1000
    val hundreds = hundredsRemainder / 100
    val romanHundreds = when (hundreds) {
        9 -> {
            "CM"
        }
        4 -> {
            "CD"
        }
        else -> {
            val prefix = if(hundreds >= 5) "D" else ""
            val hundredsRemainderMod5 = hundreds % 5
            prefix + ( 0 until hundredsRemainderMod5).map { "C" }.joinToString(separator = "")
        }
    }
    val tensRemainder = hundredsRemainder % 100
    val tens = tensRemainder / 10
    val romanTens = when (tens) {
        9 -> {
            "XC"
        }
        4 -> {
            "XL"
        }
        else -> {
            val prefix = if(tens >= 5) "L" else ""
            val tensRemainderMod5 = tens % 5
            prefix + ( 0 until tensRemainderMod5).map { "X" }.joinToString(separator = "")
        }
    }
    val ones = tensRemainder % 10
    val romanOnes = when (ones) {
        9 -> {
            "IX"
        }
        4 -> {
            "IV"
        }
        else -> {
            val prefix = if(ones >= 5) "V" else ""
            val onesRemainderMod5 = ones % 5
            prefix + ( 0 until onesRemainderMod5).map { "I" }.joinToString(separator = "")
        }
    }
    return romanThousands+romanHundreds+romanTens+romanOnes
}

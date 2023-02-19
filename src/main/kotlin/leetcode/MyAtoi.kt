fun myAtoi(s: String): Int {
    val trimed = s.trim()
    if (trimed.isEmpty()) {
        return 0
    }
    var sign = '+'
    val digits = if(trimed[0] == '-' || trimed[0] == '+'){
        sign = trimed[0]
        trimed.substring(1).takeWhile { it.isDigit() }
    } else trimed.takeWhile { it.isDigit() }

    val zeroLength = digits.takeWhile { it == '0' }.length
    val digitsExceptZero = digits.substring(zeroLength)
    if(digitsExceptZero.isEmpty()){
        return 0
    }
    if(digitsExceptZero.length > 10){
        return if (sign == '+'){
            Int.MAX_VALUE
        } else Int.MIN_VALUE
    }
    if(digitsExceptZero.length == 10) {
        if ((sign + digitsExceptZero).toLong() <= Int.MIN_VALUE) {
            return Int.MIN_VALUE
        }
        if ((sign + digitsExceptZero).toLong() >= Int.MAX_VALUE) {
            return Int.MAX_VALUE
        }
    }
    return if(sign == '-') -digitsExceptZero.toInt() else digitsExceptZero.toInt()
}

fun main() {
    println(myAtoi("21474836460"))
}

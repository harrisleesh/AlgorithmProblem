import kotlin.math.max

fun main() {
    println("hello multiply strings")
    println(multiply("9133", "0"))
}

fun multiply(num1: String, num2: String): String {
    var multiplied = ""
    var zero = ""
    (num2.length - 1 downTo 0).forEach {
        multiplied = sumString(multiplied, multiplyByChar(num1, num2[it]) + zero)
        zero += "0"
    }

    return multiplied.trimStart { it == '0' }.ifEmpty { "0" }
}


fun multiplyByChar(num1: String, num2: Char): String {
    var multipliedString = "0"
    (num1.length - 1 downTo 0).forEach {
        val multiplied = num1[it].toNum() * num2.toNum() + multipliedString[0].toNum()
        multipliedString = multiplied.toString().padStart(2, '0') + multipliedString.substring(1)
    }
    return if (multipliedString[0] == '0') multipliedString.substring(1) else multipliedString
}

fun sumString(num1: String, num2: String): String {
    val width = max(num1.length, num2.length)
    val num1Pad = num1.padStart(width, '0')
    val num2Pad = num2.padStart(width, '0')
    var sumString = "0"
    (width - 1 downTo 0).forEach {
        val sum = num1Pad[it].toNum() + num2Pad[it].toNum() + sumString[0].toNum()
        sumString = sum.toString().padStart(2, '0') + sumString.substring(1)
    }
    return if (sumString[0] == '0') sumString.substring(1) else sumString
}

fun Char.toNum() = this.toInt() - 48


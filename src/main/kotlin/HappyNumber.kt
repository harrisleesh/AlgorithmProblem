fun main() {
    println("Hello Happy number")
    println(isHappy(2))
}


fun isHappy(n: Int): Boolean {
    if (n <= 0) return false
    val record = mutableSetOf<Int>()
    var candidate = n
    do {
        var sum = 0
        while (candidate > 0) {
            val digit = candidate % 10
            sum += digit * digit
            candidate /= 10
        }
        if(record.contains(sum)) return false
        record.add(sum)
        candidate = sum
    }while (sum != 1)
    return true
}

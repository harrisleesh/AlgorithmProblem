fun main() {
    println("Hello news")

    newsString("Hi! My name is Seonghun. Nice to meet you. Where are you from? I'm from Korea", 15)
        .forEach{
            println(it)
        }
}

fun newsString(s: String, width: Int): MutableList<String> {
    val result = mutableListOf("*".repeat(width + 2))
    val splits = s.split(" ")
    val results = mutableListOf(StringBuilder("  "))
    splits.forEachIndexed { idx, it ->
        var last = results.last()
        if(last.length + it.length> width){
            results.add(StringBuilder(it))
            last = results.last()
        } else {
            last.append(it)
        }
        if (it.last() in setOf('!', '?', '.')) {
            results.add(StringBuilder("  "))
        } else {
            if(idx != splits.size - 1) last.append(" ")
        }
    }
    return (result + results.map { "*" + it.padEnd(width, ' ').toString() +"*"} + result).toMutableList()
//    return results.flatMap { str ->
//        val divided = mutableListOf<String>()
//        var dividedCount = str.length / width
//        if (str.length % width != 0) {
//            dividedCount++
//        }
//        (1.. dividedCount).forEach{
//            divided += str.substring((it - 1)* width, min(it * width, str.length))
//        }
//        divided
//    }.map { it.toString() }.toMutableList()
}

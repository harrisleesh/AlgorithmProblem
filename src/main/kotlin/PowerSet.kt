fun main() {
    println("hello powerset")
    val testSet = setOf("1", "2", "3")
    println(testSet.powerSet())
    val s = setOf(setOf<Int>())
}

fun <T> Set<T>.head(): T = this.first()
fun <T> Set<T>.tail(): Set<T> = this.drop(1).toSet()

fun <T> Set<T>.powerSet(): Set<Set<T>> {
    if(this.isEmpty()) return setOf(setOf())
    val head = this.head()
    val tail = this.tail()
    val restPowerSet = tail.powerSet()
    return restPowerSet + restPowerSet.map { it + head }
}

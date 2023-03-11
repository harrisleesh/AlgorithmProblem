package leetcode
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

fun main() {
    println("merge list")
}
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val sortedList = mutableListOf<Int>()
    lists.forEach {
        var node = it
        if(node != null) sortedList.add(node.`val`)
        while (node?.next != null){
            sortedList.add(node.next!!.`val`)
            node = node.next
        }
    }
    sortedList.sort()
    if(sortedList.isEmpty()) return null
    var start: ListNode? = null
    var prev: ListNode? = null
    sortedList.forEach{
        val newNode = ListNode(it)
        if(prev == null){
            start = newNode
        } else prev?.next = newNode
        prev = newNode
    }
    return start
}


class ListNode(val `val`: Int) {
    var next: ListNode? = null
}

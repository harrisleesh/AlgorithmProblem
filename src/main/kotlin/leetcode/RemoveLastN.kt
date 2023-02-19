import leetcode.ListNode

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
    println(removeNthFromEnd(ListNode(1), 1)?.value)
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var size = 0
    var ptr = head
    while (ptr != null) {
        size++
        ptr = ptr.next
    }

    val startFrom = size - n + 1
    if (startFrom == 1) {
        return head?.next
    }

    ptr = head
    var currentIdx = 1
    while (ptr != null) {
        if (currentIdx + 1 == startFrom) {
            ptr.next = ptr.next?.next
            break
        }
        currentIdx++
        ptr = ptr.next
    }
    return head
}

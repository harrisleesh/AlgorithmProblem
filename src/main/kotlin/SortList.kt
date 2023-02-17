import java.util.SortedSet

fun main() {
    println("hello")
    val node1 = ListNode(5)
    val node2 = ListNode(2)
    val node3 = ListNode(1)
    val node4 = ListNode(3)
    val node5 = ListNode(4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    val m = sortList(node1)
    println(m)
}


fun sortList(head: ListNode?): ListNode? {
    val nums = mutableListOf<Int>()

    var curr = head
    while(curr != null){
        nums.add(curr.value)
        curr = curr.next
    }
    nums.sort()
    val initial = ListNode(0)
    nums.fold(initial){ acc, num -> acc.next = ListNode(num)
        acc.next!!
    }

    return initial.next
}

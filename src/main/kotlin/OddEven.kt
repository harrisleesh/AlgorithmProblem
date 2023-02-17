fun main() {
    println("hello odd even")
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    val message = oddEvenList(node1)
    println(message)
    println()
}

fun oddEvenList(head: ListNode?): ListNode? {
    var isEven = false
    var evenNode = ListNode(0)
    var nextNode = evenNode
    var curr = head
    var before = head
    while(curr != null) {

        if(isEven){
            nextNode.next = ListNode(curr.value)
            nextNode = nextNode.next!!
            before?.next = curr.next
        }
        else {
            before = curr
        }
        curr = curr.next

        isEven = !isEven
    }
    before?.next = evenNode.next
    return head
}

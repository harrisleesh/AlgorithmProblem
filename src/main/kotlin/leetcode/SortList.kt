import leetcode.ListNode

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
//    val m = sortList(node1)
    val m = mergeSort(node1)
    m.printAll()
}


fun sortList(head: ListNode?): ListNode? {
    val nums = mutableListOf<Int>()

    var curr = head
    while(curr != null){
        nums.add(curr.`val`)
        curr = curr.next
    }
    nums.sort()
    val initial = ListNode(0)
    nums.fold(initial){ acc, num -> acc.next = ListNode(num)
        acc.next!!
    }

    return initial.next
}

fun mergeSort(head: ListNode?): ListNode? {
    //종료조건
    if(head?.next == null) return head
    val (left, right) = split(head)
    return merge(mergeSort(left), mergeSort(right))
}

fun split(head: ListNode?): Pair<ListNode?, ListNode?>{
    var slow = head
    var fast = head
    var separatePoint = head
    while(fast?.next != null){
        separatePoint = slow
        slow = slow?.next
        fast = fast.next?.next
    }
    separatePoint?.next = null
    return Pair(head, slow)
}

fun merge(left: ListNode?, right: ListNode?): ListNode? {
    val dummyNode = ListNode(0)
    var currNode = dummyNode
    var lNode = left
    var rNode = right
    while(lNode != null && rNode != null){
        if(lNode.`val` <= rNode.`val`){
            currNode.next = lNode
            lNode = lNode.next
        } else {
            currNode.next = rNode
            rNode = rNode.next
        }
        currNode = currNode.next!!
    }
    if(lNode == null){
        currNode.next = rNode
    } else if (rNode == null){
        currNode.next = lNode
    }
    return dummyNode.next
}

fun ListNode?.printAll(){
    var curr = this
    while(curr!= null){
        println(curr.`val`)
        curr = curr.next
    }
}

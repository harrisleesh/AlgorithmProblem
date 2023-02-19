fun main() {
    println("hello palindrome")
    val head = ListNode(1)
    head.next = ListNode(2)
    println(isPalindrome(head))

    val first = ListNode(1)
    val second = ListNode(2)
    val third = ListNode(1)
    first.next = second
    second.next = third
    println(isPalindrome(first))
}


fun isPalindrome(head: ListNode?): Boolean {
    val str = StringBuffer()
    var curr = head
    while (curr != null) {
        str.append(curr.value)
        curr = curr.next
    }
    val half = str.length / 2
    (0 until half).forEach {
        val lastIdx = str.length - it - 1
        if (str[it] != str[lastIdx]) return false
    }
    return true
}

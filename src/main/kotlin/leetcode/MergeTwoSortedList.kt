package leetcode

fun main() {
    println("hello Merge two sortedList")
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var list1Temp = list1
    var list2Temp = list2
    val result = ListNode(0)
    var resultTemp = result
    while (list1Temp != null && list2Temp != null) {
        if (list1Temp.`val` < list2Temp.`val`) {
            resultTemp.next = ListNode(list1Temp.`val`)
            list1Temp = list1Temp.next
        } else {
            resultTemp.next = ListNode(list2Temp.`val`)
            list2Temp = list2Temp.next
        }
        resultTemp = resultTemp.next!!
    }
    if(list1Temp == null) {
        resultTemp.next = list2Temp
    } else{
        resultTemp.next = list1Temp
    }
    return result.next
}

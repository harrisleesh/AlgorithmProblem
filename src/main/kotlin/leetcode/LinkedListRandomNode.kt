package leetcode

import kotlin.random.Random

class Solution(head: ListNode?) {
    private val list = mutableListOf<Int>()
    init {
        var temp: ListNode? = head
        while(temp != null){
            list.add(temp.value)
            temp = temp.next
        }
    }

    fun getRandom(): Int {
        val rand = Random.nextInt(list.size)
        return list[rand]
    }

}

package leetcode

import java.util.Stack

fun main() {
    println("hello parentheses")

    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("("))
}


fun isValid(s: String): Boolean {
    val stack = Stack<Char>()

    s.forEach {
        if ("({[".contains(it)) stack.add(it)
        else {
            if (stack.isEmpty()) return false
            val popped = stack.pop()
            if ( (it == ')' && popped == '(') ||
                (it == '}' && popped == '{') ||
                (it == ']' && popped == '[') ) {

            } else {
                return false
            }
        }
    }
    if(stack.isNotEmpty()) return false
    return true
}

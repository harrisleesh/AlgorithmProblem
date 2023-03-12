package programmers

//https://school.programmers.co.kr/learn/courses/30/lessons/161989

fun main() {
    println("hello DutChill")
    println(solution(8, 4, intArrayOf(2,3,6)))
    println(solution(5, 4, intArrayOf(1,3)))
    println(solution(4, 1, intArrayOf(1,2,3,4)))
}

fun solution(n: Int, m: Int, section: IntArray): Int {
    var answer = 0
    if(section.isEmpty()) return 0
    var nextChill = section[0]
    section.forEach {
        if(it >= nextChill){
            answer++
            nextChill += m
        }
    }
    return answer
}

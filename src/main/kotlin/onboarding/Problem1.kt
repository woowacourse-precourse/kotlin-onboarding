package onboarding

import java.util.Collections.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if (checkException(pobi) or checkException(crong))
        return -1

    val pobi_score = calculation(pobi)
    val crong_score = calculation(crong)

//    println(pobi_score)
//    println(crong_score)
//    println()

    if (pobi_score > crong_score)
        return 1
    else if (crong_score > pobi_score)
        return 2
    else
        return 0
}
fun calculation(name: List<Int>): Int {
    var answer = arrayListOf<Int>()
    for (index in name.indices) {
        var plus = 0
        var mul = 1
        var i = name[index]

        while (i != 0){
            plus += index % 10
            mul *= index % 10
            i /= 10
        }
        println(plus)
        answer.add(plus)
        answer.add(mul)

    }
    return max(answer)
}

fun checkException(name: List<Int>): Boolean {
    var answer = false
    if (name[1]!= 1+name[0])
        answer = true
    return answer
}


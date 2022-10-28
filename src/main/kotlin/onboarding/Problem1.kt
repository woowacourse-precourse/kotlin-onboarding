package onboarding

import java.util.Collections.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if (checkException(pobi) or checkException(crong))
        return -1

    val pobiScore = scoreCalculate(pobi)
    val crongScore = scoreCalculate(crong)

    if (pobiScore > crongScore)
        return 1
    if (crongScore > pobiScore)
        return 2

    return 0
}
fun scoreCalculate(name: List<Int>): Int {
    var values = arrayListOf<Int>()

    for (i in name.indices) {
        var plus = 0
        var mul = 1
        var page = name[i]

        while (page != 0){
            plus += page % 10
            mul *= page % 10
            page /= 10
        }
        values.add(plus)
        values.add(mul)
    }
    return max(values)
}

fun checkException(name: List<Int>): Boolean {
    // 바로 다음 페이지인지 확인
    if (name[1] != (name[0]+1))
        return true
    return false
}


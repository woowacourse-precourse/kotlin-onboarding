package onboarding

import java.lang.Integer.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if (!checkInput(pobi) || !checkInput(crong))
        return -1
    val pobiMax = compareNum(pobi)
    val crongMax = compareNum(crong)

    return if (pobiMax > crongMax)
        1
    else if (pobiMax < crongMax)
        2
    else
        0
}

fun checkBound(page: Int): Boolean {
    return page in 1..400
}

fun checkOdd(page: Int): Boolean {
    return page % 2 == 1
}

fun checkContinue(left: Int, right: Int): Boolean {
    return left - right == -1
}

fun checkInput(person: List<Int>): Boolean {
    val left = person[0]
    val right = person[1]

    if (!checkBound(left) || !checkBound(right))
        return false
    if (!checkOdd(left) || checkOdd(right))
        return false
    if (!checkContinue(left, right))
        return false
    return true
}

fun compareNum(person: List<Int>): Int {
    return max(calMax(person[0]), calMax(person[0]))
}

fun calMax(now: Int): Int {
    var plus = 0
    var mul = 1
    var temp = now
    while (temp > 0) {
        val cur = temp % 10

        mul *= cur
        plus += cur
        temp /= 10
    }
    return max(mul, plus)
}
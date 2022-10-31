package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(isExcept(pobi, crong)) return -1

    val pobiOddPage = splitString(pobi[0])
    val pobiEvenPage = splitString(pobi[1])
    val pobiFinalScore = max(decideScore(pobiOddPage), decideScore(pobiEvenPage))

    val crongOddPage = splitString(crong[0])
    val crongEvenPage = splitString(crong[1])
    val crongFinalScore = max(decideScore(crongOddPage), decideScore(crongEvenPage))

    return if(pobiFinalScore > crongFinalScore) 1
    else if(pobiFinalScore < crongFinalScore) 2
    else 0
}

fun splitString(page: Int): List<Int> = page.toString().toCharArray().map { it.digitToInt() }

fun decideScore(list: List<Int>): Int {
    var addScore = 0
    var mulScore = 1

    list.forEach {
        addScore += it
        mulScore *= it
    }

    return max(addScore, mulScore)
}

fun isExcept(pobi: List<Int>, crong: List<Int>): Boolean {
    if(pobi[0] <= 1 || crong[1] >= 400) return true
    if(pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) return true
    if(pobi[0] % 2 == 0 || pobi[1] % 2 == 1 || crong[0] % 2 == 0 || crong[1] % 2 == 1) return true
    return false
}
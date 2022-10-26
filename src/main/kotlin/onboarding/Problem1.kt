package onboarding

import kotlin.math.abs

/* 기능 목록
* validation check 구현
* getMaxScore 구현
* 점수 비교 구현
* */

fun isCorrectInput(pobi: List<Int>, crong: List<Int>): Boolean {
    return checkListSize(pobi, crong) &&
        checkInRange(pobi, crong) &&
        checkPageSequential(pobi, crong)
}

fun checkListSize(pobi: List<Int>, crong: List<Int>): Boolean {
    return pobi.size == 2 && crong.size == 2
}

fun checkInRange(pobi: List<Int>, crong: List<Int>): Boolean {
    for (i in pobi.indices) {
        if (pobi[i] !in 3..398 || crong[i] !in 3..398) return false
    }
    return true
}

fun checkPageSequential(pobi: List<Int>, crong: List<Int>): Boolean {
    return abs(pobi[0] - pobi[1]) == 1 && abs(crong[0] - crong[1]) == 1
}

fun play(pobi: List<Int>, crong: List<Int>): Int {
    val pobiScore = getMaxScore(pobi)
    val crongScore = getMaxScore(crong)
    return when{
        pobiScore > crongScore -> 1
        pobiScore == crongScore -> 0
        else -> 2
    }
}

fun getMaxScore(pages: List<Int>): Int {
    var maxScore = 0
    for (page in pages) {
        maxScore = maxScore.coerceAtLeast(getPlusScore(page))
        maxScore = maxScore.coerceAtLeast(getMultipleScore(page))
    }
    return maxScore
}

fun getPlusScore(page: Int): Int {
    var tempPage = page
    var score = 0
    while (tempPage > 0) {
        score += tempPage % 10
        tempPage /= 10
    }
    return score
}

fun getMultipleScore(page: Int): Int {
    var tempPage = page
    var score = 1
    while (tempPage > 0) {
        score *= tempPage % 10
        tempPage /= 10
    }
    return score
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!isCorrectInput(pobi, crong)) {
        return -1
    }
    return play(pobi, crong)
}

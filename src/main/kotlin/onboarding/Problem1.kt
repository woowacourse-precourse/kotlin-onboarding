package onboarding

import kotlin.math.abs

/* 기능 목록
* validation check 구현
* getScore 구현
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
    for(i in pobi.indices){
        if(pobi[i] !in 3 .. 398 || crong[i] !in 3 .. 398) return false
    }
    return true
}

fun checkPageSequential(pobi: List<Int>, crong: List<Int>): Boolean {
    return abs(pobi[0] - pobi[1]) == 1 && abs(crong[0] - crong[1]) == 1
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!isCorrectInput(pobi, crong)) {
        return -1
    }
    return 0
}

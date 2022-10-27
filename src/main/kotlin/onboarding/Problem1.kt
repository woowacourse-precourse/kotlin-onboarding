package onboarding

import problem1.RangeVerifier

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiRangeVerifier = RangeVerifier(pobi[0])
    val crongRangeVerifier = RangeVerifier(crong[0])
    if(!pobiRangeVerifier.verify() || !crongRangeVerifier.verify()) {
        TODO("예외처리")
    }

    return -1
}

package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {


    // 페이지가 연속된 숫자인지 확인 책을 펼치니 홀수와, 짝수가 1차이가 나와야 됨
    val answer : Int = if (pobi[1]-pobi[0] == 1 && crong[1]-crong[0] == 1){
        // 더하거나 곱한 수 중 제일 큰 수
        val pobiScore = getMaxScore(pobi)
        val crongScore = getMaxScore(crong)

        if (pobiScore > crongScore) {
            1
        } else if (pobiScore < crongScore) {
            2
        } else{
            0
        }
    }else{
        -1
    }

    return answer
}

// 최고 점수 구하는 함수
fun getMaxScore(list: List<Int>) : Int{
    var scoreF = 0
    for (i in list) {
        val score = i.toString().toMutableList().map { it - '0' }
        var muti = 1
        for (j in score) {
            muti *= j
        }
        val top = max(score.sum(), muti)
        scoreF = max(top, scoreF)
    }
    return scoreF
}
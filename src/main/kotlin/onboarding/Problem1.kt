package onboarding

import kotlin.math.max
/*
* isCorrectPages : 책 페이지가 올바른지 검사하는 함수
* calcuScore : 페이지에 따라 점수를 매기는 함수
* */
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    fun isCorrectPages(bookpage: List<Int>): Boolean {
        if(bookpage.size != 2 )
            return false
        if(bookpage[0] % 2 != 1)
            return false
        if(bookpage[1] % 2 != 0)
            return false
        if(bookpage[1]-bookpage[0] !=1 )
            return false
        return true
    }
    fun calcuScore(bookpage: List<Int>): Int {
        var score = 0; // 최종 점수
        var additionScore = 0; // 덧셈 점수
        var multipleScore = 0; // 곱셈 점수
        for (page in bookpage) {
            var numList = page.toString().chunked(1) // 한 페이지의 수 분리
            var intList = numList.map { it.toInt() }
            var sumNum = intList[0]
            var multiNum = intList[0];
            for (i in 1..intList.size-1) {
                sumNum += intList[i]
                multiNum *= intList[i]
            }
            additionScore = max(additionScore, sumNum)
            multipleScore = max(multipleScore, multiNum)
        }
        score = max(additionScore, multipleScore)
        return score;
    }


    if(isCorrectPages(pobi) && isCorrectPages(crong)){
        var pobiScore = calcuScore(pobi)
        var crongScore = calcuScore(crong)
        if(pobiScore > crongScore)
            return 1
        else if(pobiScore < crongScore)
            return 2
        else
            return 0
    }

    else
        return -1
}
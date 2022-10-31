package onboarding

import kotlin.math.max

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
        var score = 0;
        var additionScore = 0;
        var multipleScore = 0;
        for (page in bookpage) {
            var numList = page.toString().chunked(1)
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
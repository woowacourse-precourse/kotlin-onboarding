package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    val pobiScore = scoreCalculator(pobi)
    val crongScore = scoreCalculator(crong)

    return if (checkedContinuous(pobi) && checkedContinuous(crong))
        checkedResult(pobiScore, crongScore)
    else -1

}

fun scoreCalculator(num: List<Int>): Int {
    var resultScore = 0
    val compareArray = ArrayList<Int>()
    for (i in num.indices) {
        val scorePlusResult = num[i].toString().map {
            it.digitToInt()
        }.sum()
        compareArray.add(scorePlusResult)

        val scoreMultiResult =
            num[i].toString().map { it.digitToInt() }.fold(1) { answer, number -> answer * number }
        compareArray.add(scoreMultiResult)
    }

    compareArray.sorted()
    resultScore = compareArray[3]
    return resultScore
}

fun checkedResult(score1: Int, score2: Int): Int {
    var result = 0
    if (score1 > score2) result = 1
    else if (score1 < score2) result = 2
    else if (score1 == score2) result = 0
    return result
}

fun checkedContinuous(list: List<Int>): Boolean {
    return list[1] - list[0] == 1
}


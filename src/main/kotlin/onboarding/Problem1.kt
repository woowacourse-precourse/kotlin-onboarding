package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi[1] - pobi[0] == 1 && crong[1] - crong[0] == 1) {
        return startGame(pobi, crong)
    }
    return -1
}

fun startGame(pobi: List<Int>, crong: List<Int>): Int {
    val pobiScore = calcMax(pobi[0], pobi[1])
    val crongScore = calcMax(crong[0], crong[1])

    if (pobiScore != crongScore) {
        return compareFinalScore(pobiScore, crongScore)
    }
    return 0
}

fun compareFinalScore(pobiScore: Int, crongScore: Int): Int {
    if (pobiScore > crongScore) {
        return 1
    }
    return 2
}

private fun calcMax(leftPage: Int, rightPage: Int): Int {
    val leftPageMax = calcPage(leftPage)
    val rightPageMax = calcPage(rightPage)

    if (leftPageMax > rightPageMax) {
        return leftPageMax
    }
    return rightPageMax
}


private fun calcPage(page: Int): Int {
    var pagePlus = 0
    var pageMul = 1
    var tmp = page

    while (tmp != 0) {
        pagePlus += tmp % 10
        pageMul *= tmp % 10
        tmp /= 10
    }

    if (pagePlus > pageMul) {
        return pagePlus
    }
    return pageMul
}

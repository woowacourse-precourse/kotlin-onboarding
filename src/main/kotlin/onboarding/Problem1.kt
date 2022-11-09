package onboarding


fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    val pobiPoint = createMaxPobiPoint(pobi)
    val crongPoint = createMaxCrongPoint(crong)

    val invalidPage =
        pobi[RIGHT_PAGE] - pobi[LEFT_PAGE] > 1 || crong[RIGHT_PAGE] - crong[LEFT_PAGE] > 1
    if (invalidPage) return INVALID_PAGE

    if (pobiPoint == crongPoint) return DRAW
    if (pobiPoint > crongPoint) return POBI_WIN
    if (pobiPoint < crongPoint) return CRONG_WIN

    return INVALID_PAGE
}

fun createMaxPobiPoint(pobi: List<Int>): Int {
    val pobiPointList = listOf(
        createSumPage(pobi[LEFT_PAGE]),
        createSumPage(pobi[RIGHT_PAGE]),
        createMultiplePage(pobi[LEFT_PAGE]),
        createMultiplePage(pobi[RIGHT_PAGE])
    )

    val pobiMaxPoint = pobiPointList.maxOrNull()!!

    return pobiMaxPoint
}

fun createMaxCrongPoint(crong: List<Int>): Int {
    val crongPointList = listOf(
        createSumPage(crong[LEFT_PAGE]),
        createSumPage(crong[RIGHT_PAGE]),
        createMultiplePage(crong[LEFT_PAGE]),
        createMultiplePage(crong[RIGHT_PAGE])
    )
    val crongMaxPoint = crongPointList.maxOrNull()!!

    return crongMaxPoint
}


fun createSumPage(inputPage: Int): Int {
    var pagePoint = 1
    var input = inputPage
    while (input >= 1) {
        pagePoint *= input % 10
        input /= 10
    }
    return pagePoint
}

fun createMultiplePage(inputPage: Int): Int {
    var pagePoint = 1
    var input = inputPage
    while (input >= 1) {
        pagePoint *= input % 10
        input /= 10
    }
    return pagePoint
}


const val LEFT_PAGE = 0
const val RIGHT_PAGE = 1
const val DRAW = 0
const val POBI_WIN = 1
const val CRONG_WIN = 2
const val INVALID_PAGE = -1




package onboarding


fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    val pobiPagePointList = listOf(
        getSumPagePlaceValue(pobi[LEFT_PAGE]),
        getSumPagePlaceValue(pobi[RIGHT_PAGE]),
        getMultiplePagePlaceValue(pobi[LEFT_PAGE]),
        getMultiplePagePlaceValue(pobi[RIGHT_PAGE])
    )
    val ascendPobiPagePointList = pobiPagePointList.sorted()
    val maxPobiPagePoint = ascendPobiPagePointList[MAX_POINT_INDEX]

    val crongPagePointList = listOf(
        getSumPagePlaceValue(crong[LEFT_PAGE]),
        getSumPagePlaceValue(crong[RIGHT_PAGE]),
        getMultiplePagePlaceValue(crong[LEFT_PAGE]),
        getMultiplePagePlaceValue(crong[RIGHT_PAGE])
    )
    val ascendCrongPagePointList = crongPagePointList.sorted()
    val maxCrongPagePoint = ascendCrongPagePointList[MAX_POINT_INDEX]

    val invalidPage = pobi[RIGHT_PAGE] - pobi[LEFT_PAGE] > 1 || crong[RIGHT_PAGE]- crong[LEFT_PAGE] > 1
    if (invalidPage) return INVALID_PAGE

    if (maxPobiPagePoint == maxCrongPagePoint) return DRAW
    if (maxPobiPagePoint > maxCrongPagePoint) return POBI_WIN
    if (maxPobiPagePoint < maxCrongPagePoint) return CRONG_WIN

    return INVALID_PAGE
}


fun getSumPagePlaceValue(inputPage: Int): Int {
    var pagePoint = 1
    var input = inputPage
    while (input >= 1) {
        pagePoint *= input % 10
        input /= 10
    }
    return pagePoint
}

fun getMultiplePagePlaceValue(inputPage: Int): Int {
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
const val MAX_POINT_INDEX = 3
const val DRAW = 0
const val POBI_WIN = 1
const val CRONG_WIN = 2
const val INVALID_PAGE = -1




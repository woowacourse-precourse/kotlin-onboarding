package onboarding


fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    val pobiPagePointList = listOf(
        getSumPagePlaceValue(pobi[PRIMARY_ARRAY]),
        getSumPagePlaceValue(pobi[SECOND_ARRAY]),
        getMultiplePagePlaceValue(pobi[PRIMARY_ARRAY]),
        getMultiplePagePlaceValue(pobi[SECOND_ARRAY])
    )
    val ascendPobiPagePointList = pobiPagePointList.sorted()
    val maxPobiPagePoint = ascendPobiPagePointList[3]

    val crongPagePointList = listOf(
        getSumPagePlaceValue(crong[PRIMARY_ARRAY]),
        getSumPagePlaceValue(crong[SECOND_ARRAY]),
        getMultiplePagePlaceValue(crong[PRIMARY_ARRAY]),
        getMultiplePagePlaceValue(crong[SECOND_ARRAY])
    )
    val ascendCrongPagePointList = crongPagePointList.sorted()
    val maxCrongPagePoint = ascendCrongPagePointList[3]

    val invalidPage = pobi[SECOND_ARRAY] - pobi[PRIMARY_ARRAY] > 1 || crong[SECOND_ARRAY]- crong[PRIMARY_ARRAY] > 1
    if (invalidPage) return -1

    if (maxPobiPagePoint == maxCrongPagePoint) return 0
    if (maxPobiPagePoint > maxCrongPagePoint) return 1
    if (maxPobiPagePoint < maxCrongPagePoint) return 2

    return -1
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







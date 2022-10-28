package onboarding


fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    // TODO: 예외 상황 조건 만들기
    val invalidPage = pobi[1] - pobi[0] > 1 || crong[1]- crong[0] > 1
    if (invalidPage) return -1



    val pobiPagePointList = listOf(
        getSumPagePlaceValue(pobi[0]),
        getSumPagePlaceValue(pobi[1]),
        getMultiplePagePlaceValue(pobi[0]),
        getMultiplePagePlaceValue(pobi[1])
    )

    val ascendPobiPagePointList = pobiPagePointList.sorted()
    val maxPobiPagePoint = ascendPobiPagePointList[3]


    val crongPagePointList = listOf(
        getSumPagePlaceValue(crong[0]),
        getSumPagePlaceValue(crong[1]),
        getMultiplePagePlaceValue(crong[0]),
        getMultiplePagePlaceValue(crong[1])
    )
    val ascendCrongPagePointList = crongPagePointList.sorted()
    val maxCrongPagePoint = ascendCrongPagePointList[3]


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







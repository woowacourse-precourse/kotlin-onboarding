package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}

fun addPageNumber(pageNumber : Int) : Int {
    if (pageNumber < 10) {
        return pageNumber
    }
    return (pageNumber % 10) + addPageNumber(pageNumber / 10)
}

fun mulPageNumber(pageNumber : Int) : Int {
    if (pageNumber < 10) {
        return pageNumber
    }
    return (pageNumber % 10) * mulPageNumber(pageNumber / 10)
}

fun getMaxSumPage(leftPage : Int, rightPage : Int) : Int {
    if (addPageNumber(leftPage) > addPageNumber(rightPage)) {
        return addPageNumber(leftPage)
    }
    return addPageNumber(rightPage)
}

fun getMaxMulPage(leftPage: Int, rightPage: Int) : Int {
    if (mulPageNumber(leftPage) > mulPageNumber(rightPage)) {
        return mulPageNumber(leftPage)
    }
    return mulPageNumber(rightPage)
}

fun getMaxPage(player : List<Int>) : Int {
    val maxSumPage = getMaxSumPage(player[0], player[1])
    val maxMulPage = getMaxMulPage(player[0], player[1])

    if (maxSumPage > maxMulPage) {
        return maxSumPage
    }
    return maxMulPage
}

fun comparePobiMaxPageAndCrongMaxPage(pobiPageList : List<Int>, crongPageList : List<Int>) : Int {
    val pobiMaxPage = getMaxPage(pobiPageList)
    val crongMaxPage = getMaxPage(crongPageList)

    if (pobiMaxPage > crongMaxPage) {
        return 1
    }
    if (pobiMaxPage < crongMaxPage) {
        return 2
    }
    if (pobiMaxPage.equals(crongMaxPage)) {
        return 0
    }
    return -1
}

fun validatePageNumber(pobi: List<Int>, crong: List<Int>) : Boolean {
    if (pobi[0] < 1 || pobi[1] > 400) {
        return false
    }
    if (crong[0] < 1 || crong[1] > 400) {
        return false
    }
    return true
}

fun validatePageListNumber(pobi: List<Int>, crong: List<Int>) : Boolean {
    if (pobi[1] - pobi[0] != 1) {
        return false
    }
    if (crong[1] - crong[0] != 1) {
        return false
    }
    return true
}
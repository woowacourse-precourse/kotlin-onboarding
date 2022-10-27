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
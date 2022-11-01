package onboarding

const val POBI_WIN = 1
const val CRONG_WIN = 2
const val DRAW = 0
const val EXCEPTION = -1
const val MIN_PAGE = 1
const val MAX_PAGE = 400

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!isValidation(pobi, crong)) {
        return EXCEPTION
    }
    return comparePobiMaxPageAndCrongMaxPage(pobi, crong)
}

fun addPageNumber(pageNumber : Int) : Int {
    if (pageNumber < TEN) {
        return pageNumber
    }
    return (pageNumber % TEN) + addPageNumber(pageNumber / TEN)
}

fun mulPageNumber(pageNumber : Int) : Int {
    if (pageNumber < TEN) {
        return pageNumber
    }
    return (pageNumber % TEN) * mulPageNumber(pageNumber / TEN)
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
        return POBI_WIN
    }
    if (pobiMaxPage < crongMaxPage) {
        return CRONG_WIN
    }
    if (pobiMaxPage.equals(crongMaxPage)) {
        return DRAW
    }
    return EXCEPTION
}

fun validatePageNumber(pobi: List<Int>, crong: List<Int>) : Boolean {
    if (pobi[0] < MIN_PAGE || pobi[1] > MAX_PAGE) {
        return false
    }
    if (crong[0] < MIN_PAGE || crong[1] > MAX_PAGE) {
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

fun validatePageEvenOdd(pobi: List<Int>, crong: List<Int>) : Boolean {
    if (isEven(pobi[0]) || !isEven(pobi[1])) {
        return false
    }
    if (isEven(crong[0]) || !isEven(crong[1])) {
        return false
    }
    return true
}

fun isEven(value : Int) : Boolean {
    if (value % 2 == 0) {
        return true
    }
    return false
}

fun isValidation(pobi: List<Int>, crong: List<Int>) : Boolean {
    if (!validatePageEvenOdd(pobi, crong)) {
        return false
    }
    if (!validatePageNumber(pobi, crong)) {
        return false
    }
    if (!validatePageListNumber(pobi, crong)) {
        return false
    }
    return true
}
package onboarding

import kotlin.math.abs

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if (checkPage(pobi)==-1 || checkPage(crong) == -1) {
        return -1
    }
    if (checkPage(pobi) > checkPage(crong)) {
        return 1
    }
    if (checkPage(pobi) < checkPage(crong)) {
        return 2
    }
    return 0
}

fun checkPage(openedPage: List<Int>): Int {
    var leftPage = openedPage[0]
    var rightPage = openedPage[1]

    if (!isValid(leftPage, rightPage)) {
        return -1
    }

    return searchBigNum(leftPage).coerceAtLeast(searchBigNum(rightPage))
}

fun isValid(leftPage: Int, rightPage: Int): Boolean {
    if (abs(leftPage - rightPage) > 1 || leftPage == 1 || leftPage == 400 || leftPage%2 == 0 || rightPage%2 == 1) {
        return false
    }
    return true
}

fun searchBigNum(Num: Int): Int {
    var plus = 0
    var times = 1
    var n = Num
    while (n != 0) {
        var temp = n % 10
        plus += temp
        times *= temp
        n /= 10
    }

    return plus.coerceAtLeast(times)
}
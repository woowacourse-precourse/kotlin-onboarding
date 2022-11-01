package onboarding

import java.lang.Integer.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (checkValidation(pobi).not() ||
        checkValidation(crong).not()
    ) {
        return -1
    }

    return when (getPageScore(pobi).compareTo(getPageScore(crong))) {
        // pobi win
        1 -> 1
        // crong win
        -1 -> 2
        // draw
        else -> 0
    }
}

private fun checkValidation(pages: List<Int>): Boolean {
    return (pages.size != 2 ||
        pages[0] < 1 ||
        pages[1] > 400 ||
        pages[0] + 1 != pages[1] ||
        pages[1] % 2 == 1
    ).not()
}

private fun getPageScore(pages: List<Int>): Int {
    var pageSum = 0
    var pageMul = 1
    pages.forEach() { page ->
        page.toString()
            .map { it.digitToInt() }
            .forEach {
                pageSum += it
                pageMul *= it
            }
    }
    return max(pageMul, pageSum)
}

package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!isPageValid(pobi) || !isPageValid(crong)) {
        return -1
    }
}

fun isPageValid(pageNumbers: List<Int>): Boolean {
    if(pageNumbers[0] + 1 != pageNumbers[1]) {
        return false
    }

    if(pageNumbers[0] % 2 != 1 || pageNumbers[1] % 2 != 0) {
        return false
    }

    for(page in pageNumbers) {
        if(page == 1 || page == 4) {
            return false
        }
    }

    return true
}
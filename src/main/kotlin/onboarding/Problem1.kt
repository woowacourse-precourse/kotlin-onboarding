package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (isValidPages(pobi).not() || isValidPages(crong).not()) {
        return -1
    }

    val pobiScore = getMaxScore(pobi)
    val crongScore = getMaxScore(crong)
    return if (pobiScore > crongScore) {
        1
    } else if (pobiScore < crongScore) {
        2
    } else {
        0
    }
}

fun getMaxScore(pages: List<Int>): Int {
    return pages.maxOf { page ->
        val sum = page.toString().sumOf { it - '0' }
        val mul = page.toString().map { it - '0' }.reduce { total, num ->
            total * num
        }
        max(sum, mul)
    }
}

fun isValidPages(pages: List<Int>): Boolean {
    pages.forEach { page ->
        if (page !in 1..400) {
            return false
        }
    }

    return pages[0] + 1 == pages[1]
}
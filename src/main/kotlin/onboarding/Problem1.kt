package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!validPages(pobi) || !validPages(crong))
        return -1

    val scoreOfPobi = maxScoreOfPages(pobi)
    val scoreOfCrong = maxScoreOfPages(crong)

    return when {
        scoreOfPobi > scoreOfCrong -> 1
        scoreOfPobi < scoreOfCrong -> 2
        else -> 0
    }
}

fun validPages(pages: List<Int>): Boolean {
    return when {
        pages.size != 2 -> false
        pages[0] % 2 == 0 || pages[1] % 2 == 1 -> false
        pages[0] + 1 != pages[1] -> false
        pages[0] <= 1 || pages[1] >= 400 -> false
        else -> true
    }
}

fun maxScoreOfPages(pages: List<Int>): Int = pages.maxOf { scoreOfPage(it) }

fun scoreOfPage(page: Int): Int = maxOf(sumNumbersOfPage(page), multiplyNumbersOfPage(page))

fun sumNumbersOfPage(page: Int): Int = page.toString().map { it.digitToInt() }.sumOf { it }

fun multiplyNumbersOfPage(page: Int): Int = page.toString().map { it.digitToInt() }.fold(1){acc, i -> acc * i}

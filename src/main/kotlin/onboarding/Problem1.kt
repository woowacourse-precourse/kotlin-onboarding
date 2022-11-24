package onboarding


const val MIN_PAGE = 1
const val MAX_PAGE = 400
const val POBI_WIN_NUMBER = 1
const val CRONG_WIN_NUMBER = 2
const val DRAW_NUMBER = 0
const val EXCEPTION_NUMBER = -1

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    require(isPagesRange(pobi) || isPagesRange(crong)) { return EXCEPTION_NUMBER }
    require(isPages(pobi) && isPages(crong)) { return EXCEPTION_NUMBER }
    return result(getScore(pobi), getScore(crong))
}

fun addDigits(page: Int) = page.toString().toCharArray().sumOf { pageDigit -> pageDigit.digitToInt() }

fun multiplyDigits(page: Int) =
    page.toString().toCharArray().map { it.digitToInt() }.reduce { total, pageDigit -> total * pageDigit }

fun maxScore(scoreList: List<Int>) = scoreList.maxOf { score -> score }

fun getScore(pages: List<Int>): Int {
    val addDigitsMax = maxScore(pages.map { page -> addDigits(page) })
    val multiplyDigits = maxScore(pages.map { page -> multiplyDigits(page) })
    return maxScore(listOf(addDigitsMax, multiplyDigits))
}

fun isPagesRange(pages: List<Int>): Boolean {
    return pages.minOf { page -> page > MIN_PAGE } || pages.maxOf { page -> page < MAX_PAGE }
}

fun isPages(pages: List<Int>): Boolean {
    return pages.sorted().mapIndexed { index, page -> page - index }.distinct().size == 1
}

fun result(pobiScore: Int, crongScore: Int): Int {
    return when {
        pobiScore > crongScore -> return POBI_WIN_NUMBER
        pobiScore < crongScore -> return CRONG_WIN_NUMBER
        else -> DRAW_NUMBER
    }
}
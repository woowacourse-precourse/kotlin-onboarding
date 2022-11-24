package onboarding

//### 기능 목록 작성
//
//- 각 페이지 번호 더하기 (페이지)
//- 각 페이지 번호 곱하기 (페이지)
//- 값 비교하여 최대값 구하기 (더하기,곱하기)
//- 점수를 비교해 결과 출력
//- 예외 : 시작면이나 마지막면은 나오지 않는다
//- 예외 : 책 페이지는 1 부터 400 까지이다.
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
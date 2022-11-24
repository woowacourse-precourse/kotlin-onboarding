package onboarding

//### 기능 목록 작성
//
//- 각 페이지 번호 더하기 (페이지)
//- 각 페이지 번호 곱하기 (페이지)
//- 값 비교하여 최대값 구하기 (더하기,곱하기)
//- 점수를 비교해 결과 출력
//- 예외 : 시작면이나 마지막면은 나오지 않는다
//- 예외 : 책 페이지는 1 부터 400 까지이다.
const val minPage = 1
const val maxPage = 400
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}

fun addDigits(page: Int) = page.toString().toCharArray().sumOf { it.digitToInt() }

fun multiplyDigits(page: Int) =
    page.toString().toCharArray().map { it.digitToInt() }.reduce { total, num -> total * num }

fun maxScore(scoreList: List<Int>) = scoreList.maxOf { it }

fun getScore(pages: List<Int>): Int {
    val addDigitsMax = maxScore(pages.map { addDigits(it) })
    val multiplyDigits = maxScore(pages.map { multiplyDigits(it) })
    return maxScore(listOf(addDigitsMax, multiplyDigits))
}

fun isPagesRange(pages: List<Int>): Boolean {
    return pages.minOf { it > minPage } || pages.maxOf { it < maxPage }
}

fun isPages(pages: List<Int>): Boolean {
    return pages.sorted().mapIndexed { index, page -> page - index }.distinct().size == 1
}
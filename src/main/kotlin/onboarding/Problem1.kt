package onboarding

import kotlin.math.*

// 기능 목록
// 1. 책을 펼쳤을 때 페이지 번호의 각 자리 숫자를 모두 더한 값과 곱한 값을 구하고 그중 큰 수를 리턴하는 메소드 구현
// 2. 왼쪽 페이지와 오른쪽 페이지 번호 따로 1번 메소드를 실행시켜 나온 값을 비교하고 각각 pobiScore , crongScore 변수에 저장.
// 3. pobiScore 와 crongScore를 비교하여 승자를 리턴 [pobi 승 : 1 , crong 승 : 2 , 무승부 : 0 , 예외 상황 -1]
// 4. 예외처리 구현
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}

// 기능목록 1번 구현
fun calculatePageNumber(pageNumber: Int): Int {
    val pageNumberString = pageNumber.toString()
    var resultAdd = 0
    var resultMultiply = 1

    for (i: Char in pageNumberString) {
        resultAdd += Character.getNumericValue(i)
        resultMultiply *= Character.getNumericValue(i)
    }

    return max(resultAdd, resultMultiply)
}

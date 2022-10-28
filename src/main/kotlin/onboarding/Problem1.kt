package onboarding

import kotlin.math.*

// 기능 목록
// 1. 책을 펼쳤을 때 페이지 번호의 각 자리 숫자를 모두 더한 값과 곱한 값을 구하고 그중 큰 수를 리턴하는 메소드 구현
// 2. 왼쪽 페이지와 오른쪽 페이지 번호 따로 1번 메소드를 실행시켜 나온 값을 비교하고 각각 pobiScore , crongScore 변수에 저장.
// 3. pobiScore 와 crongScore를 비교하여 승자를 리턴 [pobi 승 : 1 , crong 승 : 2 , 무승부 : 0 , 예외 상황 -1]
// 4. 예외처리 구현
// 4-1. 페이지는 1부터 시작하여 400을 넘지 않아야 한다.
// 4-2. 왼쪽 페이지는 홀수 , 오른쪽 페이지는 짝수가 나와야 한다.
// 4-3. 왼쪽 페이지와 오른쪽 페이지는 1페이지가 차이나야 한다.
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    // 기능 목록 4번
    if (isException(pobi[0], pobi[1]) || isException(crong[0], crong[1])) {
        return -1
    }
    // 기능 목록 2번
    val pobiLeftPageScore = calculatePageNumber(pobi[0])
    val pobiRightPageScore = calculatePageNumber(pobi[1])
    val pobiScore = max(pobiLeftPageScore, pobiRightPageScore)

    val crongLeftPageScore = calculatePageNumber(crong[0])
    val crongRightPageScore = calculatePageNumber(crong[1])
    val crongScore = max(crongLeftPageScore, crongRightPageScore)
    // 기능 목록 3번
    return if (pobiScore > crongScore) {
        1
    } else if (pobiScore == crongScore) {
        0
    } else {
        2
    }
}

// 기능 목록 1번
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

// 기능 목록 4번
fun isException(leftPage: Int, rightPage: Int): Boolean {
    // 4-1
    if (leftPage < 1 || leftPage > 400) {
        return true
    }
    if (rightPage < 1 || rightPage > 400) {
        return true
    }
    // 4-2
    if (leftPage % 2 == 0 || rightPage % 2 != 0) {
        return true
    }
    // 4-3
    if (abs(leftPage - rightPage) != 1) {
        return true
    }
    return false
}
package onboarding

import kotlin.math.max

/**
기능 목록
- 페이지 범위가 올바른지 확인
- 왼쪽 페이지, 오른쪽 페이지의 각 자리 숫자 모두 더하기
- 왼쪽 페이지, 오른쪽 페이지의 각 자리 숫자 모두 곱하기
- 위의 네가지 숫자를 비교해서 가장 큰 수 찾기
- pobi의 가장 큰 수와 crong의 가장 큰 수 비교
- isRightPage : 1~400 페이지 안에 있는지 판별, 페이지가 범위 안에 있으면 true 반환
- isContinuousPage : 연속적인 페이지인지 판별, 페이지가 올바른 순서로 1 차이 날 경우 true 반환
- maxPage : 왼쪽 페이지 번호 각 숫자의 덧셈, 곱셈, 오른쪽 페이지 번호 각 자리의 덧셈, 곱셈 4가지 중 가장 큰 값 반환
 - cmpAddMul : 페이지 번호의 각 자리 숫자의 덧셈과 곱셈 중 더 큰 값 반환
*/

const val ERROR = -1
const val SAME = 0
const val POBI_WIN = 1
const val CRONG_WIN = 2

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if (!isRightPage(pobi, crong) || !isContinuousPage(pobi, crong)) {
        return ERROR
    }
    return if (maxPage(pobi) > maxPage(crong)) POBI_WIN
    else if (maxPage(pobi) < maxPage(crong)) CRONG_WIN
    else SAME
}

fun isRightPage(pobi: List<Int>, crong: List<Int>): Boolean {
    return 1 <= pobi[0] && pobi[0] < 400 && 1 < pobi[1] && pobi[1] <= 400 && 1 <= crong[0] && crong[0] < 400 && 1 < crong[1] && crong[1] <= 400
}

fun isContinuousPage(pobi: List<Int>, crong: List<Int>): Boolean {
    return pobi[1] - pobi[0] == 1 && crong[1] - crong[0] == 1
}

fun maxPage(list: List<Int>): Int {
    var leftPage = list[0]
    var rightPage = list[1]

    return max(cmpAddMul(leftPage), cmpAddMul(rightPage))
}

fun cmpAddMul(num: Int): Int {
    var page = num
    var add = 0
    var mul = 1

    while (page > 0) {
        val remain = page % 10
        page = page / 10
        add += remain
        mul *= remain
    }
    return max(add, mul)
}
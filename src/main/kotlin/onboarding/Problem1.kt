package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    var ans = 0
    if (!isRightPage(pobi, crong) || !isContinuousPage(pobi, crong)) {
        return -1
    }
    if (maxPage(pobi) > maxPage(crong)) ans = 1
    else if (maxPage(pobi) < maxPage(crong)) ans = 2
    return ans
}

// 1 ~ 400 페이지 안에 있는지 판별
fun isRightPage(pobi: List<Int>, crong: List<Int>): Boolean {
    return 1 <= pobi[0] && pobi[0] < 400 && 1 < pobi[1] && pobi[1] <= 400 && 1 <= crong[0] && crong[0] < 400 && 1 < crong[1] && crong[1] <= 400
}

// 페이지가 연속적인지 판별
fun isContinuousPage(pobi: List<Int>, crong: List<Int>): Boolean {
    return pobi[1] - pobi[0] == 1 && crong[1] - crong[0] == 1
}

// left_mul, left_add, right_mul, right_add 중 가장 큰 값 반환
fun maxPage(list: List<Int>): Int {
    var leftPage = list[0]
    var rightPage = list[1]

    return max(cmpAddMul(leftPage), cmpAddMul(rightPage))
}

// 덧셈과 곱셈 중 더 큰 값 반환
fun cmpAddMul(num: Int): Int {
    var page = num
    var add = 0
    var mul = 1

    while (page > 0) {
        var remain = page % 10
        page = page / 10
        add += remain
        mul *= remain
    }
    return max(add, mul)
}
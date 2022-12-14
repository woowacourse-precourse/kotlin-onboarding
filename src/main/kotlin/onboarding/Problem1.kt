package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    return if (isException(pobi, crong)) -1 else translateToReturnForm(pobi.getUserScore(), crong.getUserScore())
}

private fun isException(pobi: List<Int>, crong: List<Int>): Boolean {
    return (!pobi.checkIsRight() || !crong.checkIsRight())
}

/**
 *  예외사항 있는지 판별
 */
private fun List<Int>.checkIsRight(): Boolean {
    return this.checkOddAndEven() && this.checkCorrectPageNum() && this.checkIsStartOrEnd()
}

/**
 * 예외사항 1 : 왼쪽 수는 항상 홀수, 오른쪽 수는 항상 짝수여야 한다.
 */
private fun List<Int>.checkOddAndEven(): Boolean {
    return get(0).checkIsOdd() && get(1).checkIsEven()
}

private fun Int.checkIsOdd(): Boolean {
    return this % 2 == 1
}

private fun Int.checkIsEven(): Boolean {
    return this % 2 == 0
}

/**
 * 예외사항 2 : 마주보는 페이지이므로 항상 왼쪽 페이지 + 1 은 오른쪽 페이지가 되어야 한다.
 */
private fun List<Int>.checkCorrectPageNum(): Boolean {
    return get(0) + 1 == get(1)
}


/**
 * 예외사항 3 : 페이지는 맨 처음, 맨 끝면이 되어서는 안 된다.
 */

private fun List<Int>.checkIsStartOrEnd(): Boolean {
    return none { it == 1 || it == 400 }
}

/**
 *  왼쪽 페이지, 오른쪽 페이지 값 선별 후 최댓값 전달 (임시로 더하기만 구현)
 */
private fun List<Int>.getUserScore(): Int {
    return if (left() > right()) left() else right()
}

private fun List<Int>.left(): Int {
    return max(get(0).splitIntToList().getPlus(), get(1).splitIntToList().getMultiplyScore())
}

private fun List<Int>.right(): Int {
    return max(get(0).splitIntToList().getPlus(), get(1).splitIntToList().getMultiplyScore())
}

/**
 * 모든 숫자 더하기 했을 시 값 전달
 */
private fun List<String>.getPlus(): Int {
    var result = 0 //아래와 다르게 result의 값이 0이어야만 더하기를 했을 때 영향이 생기지 않으므로 0으로 초기값을 두었다.
    for (number in this) {
        result += number.toInt()
    }
    return result
}

/**
 * 모든 숫자 곱하기 했을 시 값 전달
 */
private fun List<String>.getMultiplyScore(): Int {
    var result = 1 //result의 기본값이 0이면 곱했을 시 항상 0이므로 곱하기 값에 영향을 주지 않으면서도 0이 되지 않는 초기값을 1로 두었다.
    for (number in this) {
        result *= number.toInt()
    }
    return result
}

private fun Int.splitIntToList(): List<String> = (toString()).split("").filter { it != "" }

private fun translateToReturnForm(pobi: Int, crong: Int): Int {
    return if (pobi > crong) {
        1
    } else if (pobi == crong) {
        0
    } else 2
}

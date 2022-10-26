package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!checkIsRight(pobi) || !checkIsRight(crong)) { //예외사항 체크 (둘 중 하나라도 false 이면 예외사항이므로 -1 리턴)
        return -1
    }
}

/**
 *  예외사항 있는지 판별
 */
private fun checkIsRight(list: List<Int>): Boolean {
    return checkOddAndEven(list)
}

/**
 * 예외사항 1 : 왼쪽 수는 항상 홀수, 오른쪽 수는 항상 짝수여야 한다.
 */
private fun checkOddAndEven(list: List<Int>): Boolean {
    return (list[0] % 2 == 1 && list[1] % 2 == 0)
}
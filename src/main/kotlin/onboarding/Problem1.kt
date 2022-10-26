package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!checkIsRight(pobi) || !checkIsRight(crong)) { //예외사항 체크 (둘 중 하나라도 false 이면 예외사항이므로 -1 리턴)
        return -1
    }
    val pobiBest = getUserScore(pobi)
    val crongBest = getUserScore(crong)
    return if (pobiBest > crongBest) {
        1
    } else if (pobiBest == crongBest) {
        0
    } else 2
}

/**
 *  예외사항 있는지 판별
 */
private fun checkIsRight(list: List<Int>): Boolean {
    return checkOddAndEven(list) && checkCorrectPageNum(list) && checkIsStartOrEnd(list)
}

/**
 * 예외사항 1 : 왼쪽 수는 항상 홀수, 오른쪽 수는 항상 짝수여야 한다.
 */
private fun checkOddAndEven(list: List<Int>): Boolean {
    return (list[0] % 2 == 1 && list[1] % 2 == 0)
}

/**
 * 예외사항 2 : 마주보는 페이지이므로 항상 왼쪽 페이지 + 1 은 오른쪽 페이지가 되어야 한다.
 */
private fun checkCorrectPageNum(list : List<Int>) : Boolean {
    return (list[0] + 1 == list[1])
}

/**
 * 예외사항 3 : 페이지는 맨 처음, 맨 끝면이 되어서는 안 된다.
 */

private fun checkIsStartOrEnd(list : List<Int>) : Boolean {
    return list[0] != 1 || list[1] != 400
}

/**
 *  왼쪽 페이지, 오른쪽 페이지 값 선별 후 최댓값 전달 (임시로 더하기만 구현)
 */
private fun getUserScore(list: List<Int>): Int {
    val left = getPlus(list[0])
    val right = getPlus(list[1])
    return if (left > right) {
        left
    } else right
}

/**
 * 모든 숫자 더하기 했을 시 값 전달
 */
private fun getPlus(int: Int): Int {
    val mList = (int.toString()).split("").filter { it != "" } // int를 공백 기준으로 String으로 쪼갠 후 공백 제거 (왜 공백제거를 하느냐 하면, 맨 앞과 맨 뒤가 공백으로 구분되어 빈 값의 배열이 생김)
    var result = 0 //아래와 다르게 result의 값이 0이어야만 더하기를 했을 때 영향이 생기지 않으므로 0으로 초기값을 두었다.
    for (i in mList) {
        result += i.toInt()
    }
    return result
}



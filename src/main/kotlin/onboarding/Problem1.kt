package onboarding

private const val POBIWIN = 1
private const val CRONGWIN = 2
private const val DRAW = 0
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (checkException(pobi, crong)) {
        return -1
    }
    val pobiNum = getBiggerPageNum(
        leftPage = pobi[0],
        rightPage = pobi[1]
    )
    val crongNum = getBiggerPageNum(
        leftPage = crong[0],
        rightPage = crong[1]
    )
    return validateWinner(pobiNum, crongNum)
}

// 기능 목록
/**
 * 예외 사항 체크
 * 좌우 페이지가 1차이가 나지 않으면 true를 반환한다.
 */
private fun checkException(pobi: List<Int>, crong: List<Int>): Boolean {
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) {
        return true
    }
    return false
}

/** 각자리 숫자를 모두 더하거나 곱한수 중 큰 수를 반환하는 함수 */
private fun compareAddAndMul(num: Int): Int {
    var userNum = num
    var addNum = 0
    var mulNum = 1
    while (userNum > 0) {
        addNum += userNum % 10
        mulNum *= userNum % 10
        userNum /= 10
    }
    return if (addNum > mulNum) addNum else mulNum
}

/** 왼쪽 페이지, 오른쪽 페이지 중 compareAddAndMul을 수행해 큰 수를 반환한다. */
private fun getBiggerPageNum(leftPage: Int, rightPage: Int): Int {
    val leftNum = compareAddAndMul(leftPage)
    val rightNum = compareAddAndMul(rightPage)
    return if (leftNum > rightNum) leftNum else rightNum
}

/**
 * 포비, 크롱 승패 반별 기능
 * 포비가 이기면 1
 * 크롱이 이기면 2
 * 무승부는 0
 */
private fun validateWinner(pobiNum: Int, crongNum: Int): Int =
    if (pobiNum == crongNum) DRAW else if (pobiNum > crongNum) POBIWIN else CRONGWIN

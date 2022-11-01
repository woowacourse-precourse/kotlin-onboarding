package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    //TODO("프로그램 구현")
    val pobiScore = calculateScore(pobi)
    val crongScore = calculateScore(crong)

    if (hasException(pobi, crong) == true)
        return -1
    if (hasException(pobi, crong) == false)
        when {
            pobiScore == crongScore -> return 0
            pobiScore > crongScore -> return 1
            pobiScore < crongScore -> return 2
        }
    return TODO("Provide the return value")
}

fun hasException(pobi: List<Int>, crong: List<Int>): Boolean {
    var pobiLeftNumber = pobi[0]
    var pobiRightNumber = pobi[1]
    var crongLeftNumber = crong[0]
    var crongRightNumber = crong[1]

    if (!(checkPageRange(pobiLeftNumber,pobiRightNumber,crongLeftNumber,crongRightNumber)
                && checkPage(pobiLeftNumber,pobiRightNumber,crongLeftNumber,crongRightNumber)))
        return true
    else
        return false
}

//페이지 범위 확인(1~400)
fun checkPageRange(pobiLeftNumber: Int, pobiRightNumber: Int, crongLeftNumber: Int, crongRightNumber: Int) : Boolean =
    pobiLeftNumber in  1..400 && pobiRightNumber in 1..400
            && crongLeftNumber in 1..400 && crongRightNumber in 1..400

//왼쪽 페이지는 홀수 오른쪽 페이지는 짝수,오른쪽 페이지가 왼쪽 페이지 + 1인지 확인
fun checkPage(pobiLeftNumber: Int, pobiRightNumber: Int, crongLeftNumber: Int, crongRightNumber: Int) : Boolean =
    pobiLeftNumber % 2 == 1 && pobiRightNumber % 2 == 0
            && pobiLeftNumber + 1 == pobiRightNumber
            && crongLeftNumber + 1 == crongRightNumber
            && crongLeftNumber % 2 == 1
            && crongRightNumber % 2 == 0

//점수 계산
fun calculateScore(list: List<Int>): Int {

    var leftNumber = list[0]
    var rightNumber = list[1]

    var leftSum = 0
    var leftProduct = 1

    var rightSum = 0
    var rightProduct = 1

    var leftMaxScore = 0
    var rightMaxScore = 0

    // 왼쪽과 오른쪽 숫자의 각 자리를 더한 값과 곱한 값
    while (leftNumber != 0) {
        leftSum += leftNumber % 10
        leftProduct *= leftNumber % 10
        leftNumber /= 10
    }

    while (rightNumber != 0) {
        rightSum += rightNumber % 10
        rightProduct *= rightNumber % 10
        rightNumber /= 10
    }

    //왼쪽 수를 각각 곱한 값과 더한 값을 비교하여 최고 점수 지정
    when  {
        rightProduct <= rightSum -> rightMaxScore = rightSum
        rightProduct >= rightSum -> rightMaxScore = rightProduct
        leftProduct <= leftSum -> leftMaxScore = leftSum
        leftProduct >= leftSum -> leftMaxScore = leftProduct
    }

    //왼쪽과 오른쪽의 최고 점수를 비교하여 더 높은 수를 최종 점수로 반환
    if (rightMaxScore > leftMaxScore)
        return rightMaxScore
    if (rightMaxScore < leftMaxScore)
        return leftMaxScore
    return TODO("Provide the return value")
}

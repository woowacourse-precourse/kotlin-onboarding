package onboarding

import kotlin.math.max

//책을 임의로 펼친다.
//왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
//오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
//2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
//점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
//시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.


/*
    Do: 페이지 번호를 리스트로 받아 +, * 연산을 통해 최댓값을 구해 리턴한다
    Parameters: 페이지 번호
    Return: 각 페이지 번호를 계산한 최댓값
 */
fun calculateMax(page: List<Int>): Int {
    val left = page[0].toString().map {
        it - '0'
    }.sum()

    val right = page[1].toString().map {
        it - '0'
    }.sum()

    return max(left, right)
}

/*
    Do: pobi와 crong 리스트 중 최댓값을 구해 결과값을 리턴한다
    Parameters: pobi와 crong의 페이지 int 리스트
    Return: 승부의 결과값 (pobi 승: 1, crong 승: 2, 무승부: 0, 예외: -1)
 */
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    // 0. Pobi와 crong의 페이지 리스트가 올바른지 확인
    if (pobi[0] + 1 != pobi[1] || crong[0] + 1 != crong[1]){
        return -1
    }
    if (1 == pobi[0] || 400 == pobi[0] || 1 == crong[0] || 400 == crong[0]){
        return -1
    }

    // 1. pobi의 최댓값을 구한다
    val pobiMax = calculateMax(pobi)

    // 2. crong의 최댓값을 구한다
    val crongMax = calculateMax(crong)

    // 3. result
    // pobi > crong
    if (pobiMax > crongMax){
        return 1
    }
    // crong > pobi
    if (crongMax > pobiMax){
        return 2
    }
    // crong = pobi
    if (pobiMax == crongMax){
        return 0
    }
    else{ // 예외처리
        return -1
    }
}

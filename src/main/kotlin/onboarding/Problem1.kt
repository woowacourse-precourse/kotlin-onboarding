package onboarding
/*
기능항목 정리
1. 예외 사항 처리 기능
2. 각 자릿수를 구하는 기능
3. 각 자릿수의 곱과 합을 비교하는 기능
4. 오른쪽 페이지 점수와 왼쪽 페이지 점수를 비교하는 기능
5. 크롱의 점수와 포비의 점수를 비교하는 기능
 */

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    val pobiLeftPage=pobi[0]
    val pobiRightPage=pobi[1]
    val crongLeftPage=crong[0]
    val crongRightPage=crong[1]

    if (pobiRightPage - pobiLeftPage != 1 || crongRightPage - crongLeftPage != 1) return -1
    if (pobiRightPage % 2 != 0 || crongRightPage % 2 != 0) return -1
    if (pobiLeftPage < 3 || pobiLeftPage > 397 || crongLeftPage < 3 || crongLeftPage > 397) return -1

    val pobiScore: Int = getBestScore(pobi)
    val crongScore: Int = getBestScore(crong)

    if (pobiScore > crongScore) return 1
    if (pobiScore < crongScore) return 2
    return 0
}

fun getBestScore(list: List<Int>): Int {
    var bestScore = 0
    for (i in list) {
        var page = i
        var plusScore = 0
        var multipleScore = 1
        while (page != 0) {
            plusScore += page % 10
            multipleScore *= (page % 10)
            page /= 10
        }
        if (plusScore >= multipleScore && plusScore >= bestScore) bestScore = plusScore //값 비교하기
        else if (multipleScore >= plusScore && multipleScore >= bestScore) bestScore = multipleScore
    }
    return bestScore
}
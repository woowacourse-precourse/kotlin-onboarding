package onboarding
/*

    기능 목록
    1. 양쪽 페이지를 비교해서 가장 큰 점수를 반환하는 함수 exceptions
    3. 배열의 곱을 구하는 식이 반복되어 함수 multiply
    2. 예외 사항에 대한 처리를 위한 함수 score

*/

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    // 예외 처리
    if (!exceptions(pobi) || !exceptions(crong)) return -1
    // 점수 측정
    val pobiScore = score(pobi)
    val crongScore = score(crong)
    // 같으면 결과값
    if (pobiScore == crongScore) return 0
    // 점수를 비교
    return if (pobiScore > crongScore) 1 else 2
}

fun score(score: List<Int>): Int {
    val left = score[0].toString()
        .map { it.digitToInt() }
    val right = score[1].toString()
        .map { it.digitToInt() }

    return (listOf(left.sumOf { it }, right.sumOf { it }, multiply(left), multiply(right)).maxOf { it })
}

fun multiply(list: List<Int>): Int {
    var mul = 1
    for (i in list) {
        mul *= i
    }
    return mul
}
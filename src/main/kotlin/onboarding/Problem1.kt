/*
기능 목록
1. findMax 함수 :
1-1. 리스트의 원소를 받아 0번 인덱스는 left, 1번 인덱스는 right로 저장한다.
1-2. left, right 모두 자릿수를 분리해 각각의 Sum변수에는 자릿수를 더한 값을, Mul 변수에는 각 자릿수를 곱한값을 저장한다.
1-3. Sum과 Mul 중 큰 수를 각각의 Max변수에 저장한다.
1-4. 마지막으로 leftMax와 rightMax 변수 중 큰 값을 리턴한다.

2. solution1 함수 :
2-1. pobiVal와 crongVal 변수에 findMax 함수로 찾은 최대값을 저장한다.
2-2. 기능 요구사항대로 승부에 따른 결과값을 출력하도록 한다.( 포비 승 : 1, 크롱 승 : 2, 무승부 : 0, 예외사항 : -1)

3. 예외사항 처리
3-1. 포비와 크롱 각각 왼쪽 페이지에 1, 오른쪽 페이지에 400이 들어오면 -1이 리턴되도록 한다.
3-2. 포비와 크롱 각각 왼쪽 페이지에 +1 한 값이 오른쪽 페이지의 값이 아니라면 -1이 리턴되도록 한다.
3-3. 각각 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아니라면 -1이 리턴되도록 한다.

*/
package onboarding


fun max(a : Int, b : Int) : Int = if(a > b) a else b

fun findMax(list: List<Int>) : Int {
    var left = list[0]
    var right = list[1]

    var leftSum = 0
    var leftMul = 1
    var rightSum = 0
    var rightMul = 1

    while(left != 0) {
        leftSum += left % 10
        leftMul *= left % 10
        left /= 10
    }
    var leftMax = max(leftSum, leftMul)

    while(right != 0) {
        rightSum += right % 10
        rightMul *= right % 10
        right /= 10
    }
    var rightMax = max(rightSum, rightMul)

    return max(leftMax, rightMax)
}
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    // TODO: ("프로그램 구현")
    //예외 상황
    if(pobi[0] == 1 || pobi[0] == 400 || pobi[0] == 400 || pobi[1] == 400 || crong[0] == 1 || crong[0] == 400 || crong[0] == 400 || crong[1] == 400) {
        return -1
    }

    if(pobi[0] + 1 != pobi[1] || crong[0] + 1 != crong[1]) {
        return -1
    }

    if(pobi[0] % 2 == 0 || pobi[1] % 2 != 0 || crong[0] % 2 == 0 || crong[1] % 2 != 0) {
        return -1
    }
    //정상 상황
    val pobiVal = findMax(pobi)
    val crongVal = findMax(crong)

    return when {
        pobiVal > crongVal -> 1
        pobiVal < crongVal -> 2
        else -> 0
    }
}

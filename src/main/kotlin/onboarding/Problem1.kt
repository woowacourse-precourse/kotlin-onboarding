package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    // 연속한 두 페이지인지 검사 (입력의 유효성 테스트)
    if(pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1){
        return -1
    }

    val p = getMaxValue(pobi)
    val c = getMaxValue(crong)
    return if(p > c){
        1
    }else if(p == c){
        0
    }else{
        2
    }
}

// 왼쪽과 오른쪽 페이지 번호에 대한 결과 중에서 최댓값 반환
fun getMaxValue(arr: List<Int>): Int {
    val left = calcMaxNumber(arr[0])
    val right = calcMaxNumber(arr[1])
    return max(left, right)
}

// 페이지의 각 자릿수를 모두 더하거나 모두 곱한 값 중에 큰 수를 반환
fun calcMaxNumber(number: Int): Int{
    var pageNum = number
    var plusNum = 0
    var mulNum = 1

    do{
        val digit = pageNum % 10 // 일의 자리수부터 계산
        plusNum += digit
        mulNum *= digit
        pageNum /= 10
    }while(pageNum > 0)

    return max(plusNum, mulNum)
}
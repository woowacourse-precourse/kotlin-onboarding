package onboarding

import kotlin.math.max

// 1. 페이지를 파라미터로 받아 각 자리수를 더한값과 더한값중 큰 반환하는 함수를 만든다.
// 2. 포비와 크롱의 값을 비교하여 조건에 맞게 출력한다.
fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    return 1
}

/**
 * 페이지의 각 자리수를 더한 값과 곱한 값 중 큰 값을 반환하는 함수
 */
fun getMaxNumber(x: Int): Int{
    var dividend = x
    var divisor = 100
    var addRes = 0      // 더한 값
    var multiRes = 1    // 곱한 값

    while(divisor>0){
        addRes += dividend/divisor

        if(dividend/divisor != 0){
            multiRes *= dividend/divisor
        }

        dividend %= divisor
        divisor /= 10
    }

    return max(addRes, multiRes)
}

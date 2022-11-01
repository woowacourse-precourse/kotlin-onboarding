package onboarding

import kotlin.math.max

// 1. 페이지를 파라미터로 받아 각 자리수를 더한값과 더한값중 큰 반환하는 함수를 만든다.
// 2. 포비와 크롱의 값을 비교하여 조건에 맞게 출력한다.
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!checkError(pobi, crong)){
        return -1
    }
    var pobiNumer = max(getMaxNumber(pobi[0]), getMaxNumber(pobi[1]))
    var crongNumber = max(getMaxNumber(crong[0]), getMaxNumber(crong[1]))

    if(pobiNumer > crongNumber){
        return 1
    }
    else if(pobiNumer < crongNumber){
        return 2
    }
    else {
        return 0
    }
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

/**
 * 제한사항을 지켰는지 확인하는 함수
 */
fun checkError(pobi: List<Int>, crong: List<Int>): Boolean{
    if(pobi[1]-pobi[0] != 1 || crong[1]-crong[0] != 1){
        return false
    }
    if(pobi[0] < 1 || pobi[0] > 400 || pobi[1] < 1 || pobi[1] > 400
            || crong[0] < 1 || crong[0] > 400 || crong[1] < 0 || crong[1] > 400){
        return false
    }
    return true
}

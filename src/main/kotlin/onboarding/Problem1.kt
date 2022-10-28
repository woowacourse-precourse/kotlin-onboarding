package onboarding

import kotlin.math.max
fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    // 예외 처리
    if (!exceptionCheck(pobi[0], pobi[1]) || !exceptionCheck(crong[0], crong[1])){
        return -1
    }
    return 0
}

// 페이지 예외 처리 기능
fun exceptionCheck(startPageNum : Int, endPageNum : Int) : Boolean{
    // 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수인지, 양쪽 페이지 차이가 1인지, 페이지 쪽수가 1부터 400안에 있는지
    return startPageNum % 2 != 0
            && endPageNum - startPageNum == 1
            && startPageNum in 1..400
            &&endPageNum in 1 ..400
}
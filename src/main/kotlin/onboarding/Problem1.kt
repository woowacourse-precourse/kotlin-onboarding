package onboarding

import kotlin.math.max

fun getMaxValue(arr: List<Int>): Int {
    // 왼쪽과 오른쪽 페이지 모두에 대해서 최댓값 계산
    val ans = mutableListOf(0, 0)
    for(i in 0..1){
        val a = arr[i] / 100
        val b = (arr[i] % 100) / 10
        val c = (arr[i] % 100) % 10

        if(a != 0){ // 세자리 수
            ans[i] = max(a * b * c, a + b + c)
        }else{
            if(b != 0){ // 두자리 수
                ans[i] = max(b * c, b + c)
            }else{ // 한자리 수
                ans[i] = c
            }
        }
    }
    return max(ans[0], ans[1])
}

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
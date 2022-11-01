package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var p_score = 0
    var c_score = 0
    var left = 0
    var right = 0
    var plus = 0
    var multiple = 1
    var answer = 0
    var flag = true

    /*예외사항 검증하는 곳
    * 예외사항
    * 1. 페이지 차이 1 초과 나는경우(테케)
    * 2. 왼쪽 페이지가 더 큰 경우(아래 조건으로 성립)
    */
    if (pobi[1]-pobi[0]!=1 || crong[1]-crong[0]!=1){
        flag = false
    }
    //포비 점수 구하기
    for (j in 0 until pobi.size) {
        // 값 초기화 시켜준 곳
        plus = 0
        multiple = 1
        // 왼쪽, 오른쪽 페이지 각 자리 수 모두 더하거나 모두 곱해 수 값 비교
        for (i in 0 until (pobi[j]).toString().length) {
            plus += (pobi[j].toString()[i]).digitToInt()
            multiple *= (pobi[j].toString()[i]).digitToInt()
        }
        if (j == 0) {
            left = max(plus, multiple)
        } else if (j == 1) {
            right = max(plus, multiple)
        }

    }
    p_score = max(left, right)
    //크롱 점수 구하기
    for (j in 0 until crong.size) {
        // 값 초기화 시켜준 곳
        plus = 0
        multiple = 1
        // 왼쪽, 오른쪽 페이지 각 자리 수 모두 더하거나 모두 곱해 수 값 비교
        for (i in 0 until (crong[j]).toString().length) {
            plus += (crong[j].toString()[i]).digitToInt()
            multiple *= (crong[j].toString()[i]).digitToInt()
        }
        if (j == 0) {
            left = max(plus, multiple)
        } else if (j == 1) {
            right = max(plus, multiple)
        }

    }
    c_score = max(left, right)
    // 포비 점수와 크롱 점수 비교
    /*
    * 포비가 이긴다면 1, 크롱이 이긴다면 2
    * 무승부는 0, 예외는 -1 return
    * */
    if (flag==false) { // 예외사항
        answer = -1
    } else if (p_score > c_score) {
        answer = 1
    } else if (p_score < c_score) {
        answer = 2
    } else if (p_score == c_score) {
        answer = 0
    }

    return answer
}

package onboarding
import kotlin.math.*

fun solution1(pobi: List<Int>, crong: List<Int>): Int? {
    // 자릿수 더하는 함수
    fun sum(k : Int) : Int{
        var answer = 0
        var input = k
        while(input != 0) {
            answer += input % 10
            input /= 10
        }
        return answer
    }
    // 자릿수 곱하는 함수
    fun mul(k : Int) : Int{
        var answer = 1
        var input = k
        while(input != 0) {
            answer *= input % 10
            input /= 10
        }
        return answer
    }
    /*
        solution1 시작
    */
    var pobi_0 = pobi.get(0)
    var pobi_1 = pobi.get(1)
    var crong_0 = crong.get(0)
    var crong_1 = crong.get(1)

    // 예외상황
    if(pobi_1-pobi_0!=1 || crong_1-crong_0!=1){
        return -1
    }
    // 정상상황 -> 각 캐릭터의 가장 큰 수를 점수처리
    var score_pobi = max( max(sum(pobi_0), mul(pobi_0)), max(sum(pobi_1), mul(pobi_1)) )
    var score_crong = max( max(sum(crong_0), mul(crong_0)), max(sum(crong_1), mul(crong_1)) )

    // 승무패 유무
    if (score_pobi > score_crong){ // 포비가 이기는 경우 : 1
        return 1
    }
    else if (score_pobi < score_crong){ // 크롱이 이기는 경우 : 2
        return 2
    }
    else {  // 무승부 경우 : 0
        return 0
    }
}

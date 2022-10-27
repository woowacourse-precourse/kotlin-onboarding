package onboarding
import kotlin.math.*
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    /*
    [기능 목록]
    1. 최대값을 구하는 함수 구현
        a) 홀수 페이지의 각 자릿수 합과 곱을 구해 큰 수 비교
        b) 짝수 페이지의 각 자릿수 합과 곱을 구해 큰 수 비교
        c) a,b번의 값 중 큰 수를 리턴
    2. pobi와 crong의 점수 비교
    3. 예외 처리
        a) 왼쪽 페이지가 짝수가 아닌 경우
        b) 오른쪽 페이지가 홀수가 아닌 경우
        c) 두 페이지가 연속적이지 않은 경우
        d) 첫 페이지나 마지막 페이지를 펼치는 경우
     */
    if (pobi[0] % 2 != 1 || crong[0] % 2 != 1){
        return -1
    }
    else if (pobi[1] % 2 != 0 || pobi[1] % 2 != 0){
        return -1
    }
    else if (pobi[1]-pobi[0] != 1 || crong[1]-crong[0] != 1){
        return -1
    }
    else if (pobi[0] == 0 || crong[1] == 0){
        return -1
    }
    println("pobi max : ${getMax(pobi)} | crong max : ${getMax(crong)}")
    return 1
}

fun getMax(ls: List<Int>): Int {
    var max = 0
    for (i in ls) {
        var sum = 0
        var mul = 1
        var n = i

        while (n > 0) {
            sum += n % 10
            mul *= n % 10
            n /= 10
        }
        if (max(sum, mul) > max) {
            max = max(sum, mul)
        }
    }
    return max
}


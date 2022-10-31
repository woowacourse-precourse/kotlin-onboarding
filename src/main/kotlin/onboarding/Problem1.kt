package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
//    입력 : 포비랑 크롱이가 책을 펼친 값 [x1,x2] [y1,y2]

//    최대값을 넣을 변수를 지정
        var maxPobi = 0
        var maxCrong = 0

//    페이지에서 나올 수 있는 모든 결과값 중 가장 큰 수를 구한다.

        var sum_number = 0
        var multiply_number = 1

        var tmp = pobi[0]

        while (tmp != 0) {
            sum_number += firstDigitCal(tmp)
            multiply_number *= firstDigitCal(tmp)
            tmp = divideBy10(tmp)
        }

        maxPobi = max(sum_number, multiply_number, maxPobi)
        multiply_number = 1
        sum_number = 0

        tmp = pobi[1]
        while (tmp != 0) {
            sum_number += firstDigitCal(tmp)
            multiply_number *= firstDigitCal(tmp)
            tmp = divideBy10(tmp)
        }

        maxPobi = max(sum_number, multiply_number, maxPobi)
        multiply_number = 1
        sum_number = 0


        tmp = crong[0]
        while (tmp != 0) {
            sum_number += tmp % 10
            multiply_number *= tmp % 10
            tmp = divideBy10(tmp)
        }

        maxCrong = max(sum_number, multiply_number, maxCrong)
        multiply_number = 1
        sum_number = 0


        tmp = crong[1]
        while (tmp != 0) {
            sum_number += firstDigitCal(tmp)
            multiply_number *= firstDigitCal(tmp)
            tmp = divideBy10(tmp)
        }
        maxCrong = max(sum_number, multiply_number, maxCrong)
//

//    점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
        var answer = scoreCompare(maxPobi, maxCrong)

    //    시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1 )
        answer = -1

//    포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 함수를 완성하라.
return answer
}

//명칭을 동사로 바꾸고, 좀 더 자세하게 적어주기
fun firstDigitCal ( a : Int) : Int {
    return a%10
}

fun divideBy10 (a : Int) : Int {
    return a/10
}

fun scoreCompare(a:Int, b:Int) : Int{
    var answer = 0

    if (a > b) {
        answer = 1
    }

    if (a < b){
        answer =  2
    }

    if (a == b) {
        answer =  0
    }

   return answer
}

fun max( a: Int, b:Int, c:Int):Int{

    var number = 0

    if (a >= b && a >= c){
        number = a
    }
    if (b >= c && b >= a){
        number = b
    }
    if (c >= a && c >= b){
        number = c
    }
    return number
}

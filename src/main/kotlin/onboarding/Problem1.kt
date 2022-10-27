package onboarding

import java.lang.Integer.max

fun solution1(pobi: List<Int>, crong: List<Int>) {

    var Pobi_Result = 0
    var Crong_Result = 0

    if (pobi[0] == crong[0]) {
        print(-1)
    }

    if (pobi[0] > 99)
        Pobi_Result = over_100(pobi)
    else if(pobi[0] < 100)
        Pobi_Result = under_100(pobi)

    if (crong[0] > 99)
        Crong_Result = over_100(crong)
    else if (crong[0] < 100)
        Crong_Result = under_100(crong)


    print(pobi)
    print(crong)
    print(Pobi_Result)
    print(Crong_Result)

    if (Pobi_Result > Crong_Result)
        print(1)
    else if (Pobi_Result < Crong_Result)
        print(2)
    else if (Pobi_Result == Crong_Result)
        print(0)

}
fun over_100(Target: List<Int>): Int {
    //(2)왼쪽 각자리 숫자를 모두 더하거나 곱한 수 중 큰 수를 구하기
    val left_pobi_100 = Target[0] / 100 % 10
    val left_pobi_10 = Target[0] / 10 % 10
    val left_pobi_1 = Target[0] % 10

    val Lpobi = max(left_pobi_100 + left_pobi_10 + left_pobi_1, left_pobi_100 * left_pobi_10 * left_pobi_1)

    //(3)오른쪽 각자리 숫자를 모두 더하거나 곱한 수 중 큰 수를 구하기
    val right_pobi_100 = Target[0] / 100 % 10
    val right_pobi_10 = Target[0] / 10 % 10
    val right_pobi_1 = Target[0] % 10 + 1

    val Rpobi = max(right_pobi_100 + right_pobi_10 + right_pobi_1, right_pobi_100 * right_pobi_10 * right_pobi_1)

    //(4)둘중 가장 큰수가 점수
    var fun_Result = max(Lpobi, Rpobi)
    return fun_Result
}

fun under_100(Target: List<Int>): Int {
    //(2)왼쪽 각자리 숫자를 모두 더하거나 곱한 수 중 큰 수를 구하기
    val left_pobi_10 = Target[0] / 10 % 10
    val left_pobi_1 = Target[0] % 10

    val Lpobi = max(left_pobi_10 + left_pobi_1,  left_pobi_10 * left_pobi_1)

    //(3)오른쪽 각자리 숫자를 모두 더하거나 곱한 수 중 큰 수를 구하기
    val right_pobi_10 = Target[0] / 10 % 10
    val right_pobi_1 = Target[0] % 10 + 1

    val Rpobi = max(right_pobi_10 + right_pobi_1, right_pobi_10 * right_pobi_1)

    //(4)둘중 가장 큰수가 점수
    var Pobi_Result = max(Lpobi, Rpobi)
    return Pobi_Result
}
fun main()= with(System.`in`.bufferedReader()){

    //(1)임의의 변수 리스트에 삽입
    val range = (1..399)
    var pobi:List<Int> = listOf(range.random())
    var crong:List<Int> = listOf(range.random())

    solution1(pobi, crong)
}
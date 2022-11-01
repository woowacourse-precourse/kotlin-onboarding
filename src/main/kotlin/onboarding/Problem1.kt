package onboarding

import java.util.*

//기능 정리
//각 유저가 펼친 페이지에서 더하거나 곱했을 때 큰값을 찾는 기능
//숫자를 문자로 전환하여 분리

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var result: Int = 0
    return result
}

fun calculatePage(StringConversion: String): Int {
    var PlusNum = 0
    var MultiplyNum = 1
    var maxValue: Int
    for (j in 0..StringConversion.length - 1) {
        //문자열로 분리하여 양쪽페이지의 최대 값을 저장 ex) 2 2 7
        val stringNumber = StringConversion.substring(j until j + 1).toInt()
        PlusNum = PlusNum + stringNumber
        MultiplyNum = MultiplyNum * stringNumber
    }
    if (PlusNum > MultiplyNum) {
        maxValue = PlusNum
    } else
        maxValue = MultiplyNum

    return maxValue
}

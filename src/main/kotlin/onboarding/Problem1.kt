package onboarding

import kotlin.math.*

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}

fun findMaxNum(list: List<Int>): Int{

    var maxNum = 0

    for(i in list){
        var plusNum = 0; var mulNum = 1; var tmp = i

        while(tmp!=0){
            plusNum += tmp % 10
            mulNum *= tmp % 10
            tmp /= 10
        }

        maxNum = max(max(mulNum, plusNum), maxNum)
    }

    return maxNum

}
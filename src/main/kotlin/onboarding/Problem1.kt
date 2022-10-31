package onboarding

import kotlin.math.*

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiMaxNum = findMaxNum(pobi)
    val crongMaxNum = findMaxNum(crong)

    if(pobiMaxNum > crongMaxNum) return 1
    else if(pobiMaxNum < crongMaxNum) return 2
    else if(pobiMaxNum == crongMaxNum) return 0
    else return -1
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
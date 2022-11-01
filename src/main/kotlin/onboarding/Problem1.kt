package onboarding

import org.assertj.core.api.Assertions.assertThat

import kotlin.math.*

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    val pobiMaxNum = findMaxNum(pobi)
    val crongMaxNum = findMaxNum(crong)

    // 제한사항 예외처리
    if(pobi.size != 2 || crong.size != 2 || pobi[1]-pobi[0] != 1 || crong[1]-crong[0] != 1) return -1

    // 경우에 따라 결과 값 나누기
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
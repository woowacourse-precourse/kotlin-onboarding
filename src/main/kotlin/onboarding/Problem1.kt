@file:Suppress("UNREACHABLE_CODE", "DEPRECATED_IDENTITY_EQUALS")

package onboarding

import java.util.*

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
    var result: Int = 0

    if(exception(pobi)==1 && exception(crong) ==1){
        return -1
    }//1.입력값이 예외사항인지 확인한다.


}
//입력값이 예외사항인지 확인한다.
fun exception(member: List<Int>): Int {
    var outcome: Int  = 0
    if(member[0] !== (member[1]+1)){
        outcome = 0
    }
    else if(member[0]==1 || member[1]==400){
        outcome = 0
    }
    else{
        outcome = 1
    }
    return outcome
}

//포비와 크롱값을 계산한다.
fun Calculation(number: List<Int>): Int {
    var leftoutcome1: Int = 0
    var rightoutcome1: Int = 0
    var leftoutcome2: Int = 0
    var rightoutcome2: Int = 0
    var finally:Int = 0
    var outcome= arrayListOf<Int>()
    leftoutcome1 = (number[0]/100) + ((number[0]/10)-((number[0]/100)*100)) + (number[0]-((number[0]/100)*100) - ((number[0]/10)*10))
    rightoutcome1 = (number[1]/100) + ((number[1]/10)-((number[1]/100)*100)) + (number[1]-((number[1]/100)*100) - ((number[1]/10)*10))

    leftoutcome2 = (number[0]/100) * ((number[0]/10)-((number[0]/100)*100)) * (number[0]-((number[0]/100)*100) - ((number[0]/10)*10))
    rightoutcome2 = (number[1]/100) * ((number[1]/10)-((number[1]/100)*100)) * (number[1]-((number[1]/100)*100) - ((number[1]/10)*10))

    outcome.add(leftoutcome1)
    outcome.add(rightoutcome1)
    outcome.add(leftoutcome2)
    outcome.add(rightoutcome2)

    finally = Collections.max(outcome)
    return finally


}

//기능별 목록
//1. 입력값이 예외사항인지 확인한다.
//2. 포비값을 계산한다.
//3. 크롱값을 계산한다.
//4. 결과를 리턴한다.
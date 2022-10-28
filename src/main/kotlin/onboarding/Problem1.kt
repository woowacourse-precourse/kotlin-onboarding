@file:Suppress("UNREACHABLE_CODE", "DEPRECATED_IDENTITY_EQUALS")

package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
    var result: Int = 0

    if(exception(pobi)==1 && exception(crong) ==1){
        return -1
    }//1.입력값이 예외사항인지 확인한다.





}
//1.입력값이 예외사항인지 확인한다.
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


//기능별 목록
//1. 입력값이 예외사항인지 확인한다.
//2. 포비값을 계산한다.
//3. 크롱값을 계산한다.
//4. 결과를 리턴한다.
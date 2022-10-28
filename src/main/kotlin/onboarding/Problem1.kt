package onboarding

//기능별 목록
//1. 입력값이 예외사항인지 확인한다.
//2. 포비와 크롱 값을 게산한다.
//4. 계산한 값을 기반으로 결과를 리턴한다.

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobiresult:Int = 0
    var crongresult:Int = 0
    //입력값이 예외사항인지 확인한다
    if(exception(pobi) || exception(crong)){
        return -1
    }
    return 0
}
//입력값이 예외사항인지 확인하는 함수
fun exception(member: List<Int>): Boolean{
    if(member[0]+1 == (member[1])){ //펼친 페이지가 연속 숫자인지 확인
        return false
    }
    else if(member[0]==1 || member[1]==400){    //펼친 페이지가 첫장과 마지막장인지 확인
        return false
    }
    return true
}

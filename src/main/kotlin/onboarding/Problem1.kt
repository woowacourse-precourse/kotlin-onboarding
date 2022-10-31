package onboarding

//기능별 목록
//1. 입력값이 예외사항인지 확인한다.
//2. 포비와 크롱 값을 게산한다.
//4. 계산한 값을 기반으로 결과를 리턴한다.

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    //입력값이 예외사항인지 확인한다
    if (exception(pobi) || exception(crong)) {
        return -1
    }

    //포비와 크롱값을 함수를 통해 계산하고 요구조건에 맞는 결과를 리턴한다.
    val pobiresult: Int = calculation(pobi)
    val crongresult: Int = calculation(crong)
    if (pobiresult > crongresult) {   //포비가 크롱보다 클 때
        return 1
    } else if (pobiresult < crongresult) {  //포비가 크롱보다 작을 때
        return 2
    }
    return 0    //무승부일 때
}

//입력값이 예외사항인지 확인하는 함수
fun exception(member: List<Int>): Boolean {
    if (member[0] + 1 == (member[1])) { //펼친 페이지가 연속 숫자인지 확인
        return false
    } else if (member[0] == 1 || member[1] == 400) {    //펼친 페이지가 첫장과 마지막장인지 확인
        return false
    }
    return true
}

//포비와 크롱값을 계산해 최대값을 리턴하는 함수
fun calculation(number: List<Int>): Int {
    var leftnumber: Int = number[0]
    var rightnumber: Int = number[1]
    val answer: ArrayList<Int> = arrayListOf(leftnumber, rightnumber, 1, 1)    //각 결과 값을 저장하는 리스트 생성

    answer[0] = number[0].toString().fold(0) { acc, it -> acc + (it - '0') }    //각자리 덧셈
    answer[1] = number[1].toString().fold(0) { acc, it -> acc + (it - '0') }

    while (leftnumber != 0) {   //각자리 곱셈
        answer[2] = ((leftnumber % 10) * answer[2])
        leftnumber /= 10

    }
    while (rightnumber != 0) {
        answer[3] = ((rightnumber % 10) * answer[3])
        rightnumber /= 10

    }

    answer.sort()   //정렬을 통해 최댓값을 찾는다.
    return answer[3]
}

package onboarding
/*
    기능 목록
    제시된 숫자를 모두 String 타입으로 이어 붙인다음 filter 함수로 3, 6, 9의 개수를 반환하는 함수
 */


fun solution3(number: Int): Int  = (1..number)
    .joinToString("") { it.toString() }
    .filter { it == '3' || it == '6' || it == '9'}
    .length

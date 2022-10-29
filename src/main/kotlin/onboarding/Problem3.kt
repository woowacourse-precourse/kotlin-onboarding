package onboarding

/*
기능 목록
- 각 자리 숫자가 3의 배수인지 판별
- 손뼉 횟수 결정
*/

fun processDigit(num: Int): Int {
    var n = num
    var r = 0
    while (n != 0) {
        if ((n % 10) % 3 == 0)
            r++
        n /= 10
    }
    return r
}

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

package onboarding

/* 기능 목록
* get369Count 구현
* N이하 입력에 대해 3,6,9 개수 저장
* 누적 합 구현
* */

fun Int.get369Count() = this.toString().count { it == '3' || it == '6' || it == '9' }


fun solution3(number: Int): Int {
    return 0
}

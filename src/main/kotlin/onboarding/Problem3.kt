package onboarding

// 기능 목록
// 1. 박수를 몇번 쳐야하는지 체크하는 메소드 구현
// 2. 1부터 number까지 반복하며 1번 메소드를 호출하고 return 값에 따라 result값을 1씩 증가시킨다.
fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

fun countClap(targetNumber: Int): Int {
    val targetNumberString = targetNumber.toString()
    var count = 0

    for (i in targetNumberString.indices) {
        if (targetNumberString[i] == '3') {
            count++
        }
        if (targetNumberString[i] == '6') {
            count++
        }
        if (targetNumberString[i] == '9') {
            count++
        }
    }

    return count
}

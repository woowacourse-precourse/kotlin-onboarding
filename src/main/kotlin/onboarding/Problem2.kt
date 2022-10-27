package onboarding

fun solution2(cryptogram: String): String {
    /*
    [기능 목록]
    1. 연속으로 중복된 문자 제거
        a) 중복이 시작된 문자와 중복된 마지막 문자의 인덱스 찾기
        b) 중복된 인덱스 범위 제거
    2. 연속으로 중복된 문자가 없을 때까지 반복
     */
    var ls = cryptogram.toMutableList()

    var duplication = false // 중복인 마지막 인덱스를 구하기 위해, 중복 상태 (duplication) 변수 사용
    var prev = 0
    var last = 0

    for (i in 1 until ls.size){
        if (ls[prev] != ls[i]) {
            if (duplication) {
                break
            }
            prev = i
        }
        else if (ls[prev] == ls[i]) {
            duplication = true
            last = i
        }
    }

    for (i in last downTo prev) {
        ls.removeAt(i)
    }
    println("${ls.joinToString("")}")
    return ls.joinToString("")
}
